import java.sql.SQLException;

public class SQLFormation {
    public static void main(String[] args){ }

    public static boolean LoginSQLFRomat(String login, String password) throws SQLException, ClassNotFoundException {
        boolean LoginIsDone = false;
        String sqlqwery = "SELECT Login FROM logs WHERE Login = " + "'" + login + "'";
        //System.out.println(SQLconnect.ExequteSQL(sqlqwery));
        sqlqwery = "SELECT Password FROM logs WHERE Login = " + "'" + login + "'";
        //System.out.println(SQLconnect.ExequteSQL(sqlqwery));
        if (password.equals(SQLconnect.ExequteSQL(sqlqwery))){
            return LoginIsDone = true;
        }
        else {
            System.out.println("Invalid Password!");
        }

        return LoginIsDone;
    }

    public static boolean RegistrationSQLFormat(String FName, String SName, String BDay, String login, String password) throws SQLException, ClassNotFoundException {
        boolean FormatIsDone = false;
        String sqlqwery = "INSERT INTO logs (FName, SName, BDay, Login, Password) VALUES (" + "'" + FName + "'" + ", " + "'" + SName + "'" + ", " + "'" + BDay + "'" + ", " + "'" + login + "'" + ", " + "'" + password + "'" + ")";
        if (SQLconnect.ExequteUpdateSQL(sqlqwery) == true) {
            return FormatIsDone == true;

        } else {
            return FormatIsDone;
        }
    }


}
