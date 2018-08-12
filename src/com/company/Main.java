package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Login();
    }
    //----------------------------------------------------------------------
    public static void Login() throws IOException{
        String Login;
        String PassPhrase;
        BufferedReader RLogin = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader RPassPhrase = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Login:");
        Login = RLogin.readLine();
        //System.out.print(LoginPass(Login));
        if (LoginCheck(Login) == true){
            System.out.print("Password:");
            PassPhrase = RPassPhrase.readLine();
            if (PassCheck(HashFunction(PassPhrase)) == true){
                System.out.println("Hello, " + Login);
            }
            else {
                System.out.print("Wrong password");
            }

        }
        else {
            System.out.print("There is no such login");
        }
    }
    //-----------------------------------------------------------------------------------
    private static String HashFunction(String PassPhrase){
        String Hash = "";

        String Salt = "3GRsNLRJdBzafAvftA6gY23U";
        Hash = Salt + PassPhrase;
        return Hash;
    }
    //---------------------------------------------------------------------------------------
    private static boolean PassCheck(String Hash){
        String PasswordHash = "3GRsNLRJdBzafAvftA6gY23U112345678";
        boolean Result = false;
        //Part, where Prog check does it match a Hash and Login (This is imitation of that process)
        if (Hash.equals(PasswordHash)){
            Result = true;
            return Result;
        }
        else {
            return Result;
        }
    }
    //-----------------------------------------------------------------------------------
    private static boolean LoginCheck(String Login){
        String PassHash = null;
        String DBLogin = "Bylly";
        boolean DBCheck = false;
        //Here we take from DataBase info about User's Login and if we have that login we are let user go on (This is imitation of that process)
        if (Login.equals(DBLogin)){
            DBCheck = true;
            return DBCheck;
        }
        else {
            return DBCheck;
        }
    }
    //-----------------------------------------------------------------------------------
}
