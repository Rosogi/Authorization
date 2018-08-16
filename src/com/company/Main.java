package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String L = "login";
        String R = "registration";
        String ch;
        BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "84997934016";
        Connection connection = null;
        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            System.out.println("registration or login?");
            ch = choice.readLine();
            if (ch.equals(L)) {
                Login();
            } else if (ch.equals(R)) {
                Registration();
            } else {
                System.out.println("Exit");
                System.out.println("Closing the connection.");
                if (connection != null) try {
                    connection.close();
                } catch (SQLException ignore) {
                }
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------
    private static void Login() throws IOException, NoSuchAlgorithmException {
        String Login;
        String PassPhrase;
        BufferedReader RLogin = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader RPassPhrase = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Login:");
        Login = RLogin.readLine();
        //System.out.print(LoginPass(Login));
        if (LoginCheck(Login) == true) {
            System.out.print("Password:");
            PassPhrase = RPassPhrase.readLine();
            if (PassCheck(HashFunction(PassPhrase)) == true) {
                System.out.println("Hello, " + Login);
            } else {
                System.out.print("Wrong password");
            }

        } else {
            System.out.print("There is no such login");
        }
    }
    //-----------------------------------------------------------------------------------
    private static void Registration() throws IOException {
        String Name;
        String Login;
        String Email;
        String Password1;
        String Password2;
        BufferedReader RName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader RLogin = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader REmail = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader RPassword = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader RRPassword = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What's is you'r name?");
        Name = RName.readLine();
        System.out.println("You'r Login?");
        Login = RLogin.readLine();
        System.out.println("You'r Email?");
        Email = REmail.readLine();
        System.out.println("You'r Password?");
        Password1 = RPassword.readLine();
        System.out.println("Repeat you'r Password");
        Password2 = RRPassword.readLine();
        if (Password1.equals(Password2)){
            System.out.println("Registration is complete");
            //Here we need to do a write to DataBase

        }
        else {
            System.out.println("Passwords do not match");
        }

    }
    //-----------------------------------------------------------------------------------
    private static String HashFunction(String PassPhrase) throws NoSuchAlgorithmException {
        //MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String Hash = "";
        String Salt = "3GRsNLRJdBzafAvftA6gY23U";
       // PassPhrase = PassPhrase + Salt;
        MessageDigest p = MessageDigest.getInstance("MD5");
        byte[] data = PassPhrase.getBytes();
        p.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, p.digest());
        Hash =  String.format("%1$032X", i);
        return Hash;
    }
    //---------------------------------------------------------------------------------------
    private static boolean PassCheck(String Hash) {
        String PasswordHash = "25d55ad283aa400af464c76d713c07ad";
        boolean Result = false;
        Hash = Hash.toLowerCase();
        //Part, where Prog check does it match a Hash and Login (This is imitation of that process)
        if (Hash.equals(PasswordHash)) {
            Result = true;
            return Result;
        } else {
            return Result;
        }
    }
    //-----------------------------------------------------------------------------------
    private static boolean LoginCheck(String Login) {
        String PassHash = null;
        String DBLogin = "Bylly";
        boolean DBCheck = false;
        //Here we take from DataBase info about User's Login and if we have that login we are let user go on (This is imitation of that process)
        if (Login.equals(DBLogin)) {
            DBCheck = true;
            return DBCheck;
        } else {
            return DBCheck;
        }
    }
    //-----------------------------------------------------------------------------------
   /* private static boolean RegWrite (Connection con, String Name, String login, String Password){
        boolean Success = false;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("");
            while (rs.next()){
                String string = rs.getString("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return Success;
    } */
}