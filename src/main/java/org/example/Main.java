import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/finance_tracker";
    private static final String USER = "root";  // Default XAMPP user
    private static final String PASSWORD = "";  // Default XAMPP password is empty

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
