
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "your_password";

        String query = "DELETE FROM users WHERE id = ?";

        try (Connection con =
                 DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, 2);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User record deleted successfully.");
            } else {
                System.out.println("No user record found with ID 2.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
