import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudent {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Connection is null. Exiting.");
                return;
            }

            String sql = "INSERT INTO students (name, course) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "John Doe");
            stmt.setString(2, "Computer Science");

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
