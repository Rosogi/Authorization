import java.sql.*;

public class SQLconnect {
    public static void main(String args[]){}

    public static boolean ExequteUpdateSQL(String sqlqwery) throws ClassNotFoundException, SQLException {
        boolean PrepareIsDone = false;//Тут надо подставить свои значения
        String url = "jdbc:mysql://localhost:3306/secondtest?autoReconnect=true&useSSL=false";//часть после знака вопроса - чистая магия дабы убрать ексепшоны по поводу SSL в MYSQL
        String username = "root";
        String password = "4208778";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlqwery);

        }

        finally {

        }
        return PrepareIsDone;
    }
    public static String ExequteSQL(String sqlqwery) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/secondtest?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "4208778";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlqwery);
            while (resultSet.next()){
                String string = resultSet.getString("Password");
                return string;
            }
            resultSet.close();
            statement.close();
        }
        finally {
            connection.close();
        }
        return "0";
    }

}