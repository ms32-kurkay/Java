import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;
    private static String username = "root";
    private static String URL = "jdbc:mysql://localhost:3306/lab12?&serverTimezone=Europe/Moscow";
    private static String password = "root";

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try{
                connection = DriverManager.getConnection(URL, username, password);
                System.out.println("Successful connection");
            }catch (SQLException e){}
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not founded");
            e.printStackTrace();
        }
        return connection;
    }
}
