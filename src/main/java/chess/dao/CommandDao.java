package chess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static chess.dao.DBConnection.getConnection;

public class CommandDao {
    public void insert(Long roomId, String command) {
        String query = "INSERT INTO command (room_id, content) VALUES (?, ?)";

        try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, roomId);
            pstmt.setString(2, command);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("insert Error");
        }
    }

    public List<String> selectAll(Long roomId) {
        String query = "SELECT * FROM command WHERE room_id = (?)";
        List<String> commands = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, roomId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                commands.add(rs.getString("content"));
            }
        } catch (SQLException e) {
            System.err.println("select All Error");
        }
        return commands;
    }


    public void deleteAll() {
        String query = "DELETE FROM command";
        try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("delete All Error");
        }
    }
}
