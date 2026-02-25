import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/login";

        String user = "root";

        String password = "";

        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

}