package DAO;

import DTO.UserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    //    private static final String DB_URL = "jdbc:mysql://tlswltjq.iptime.org:3306/PhotoNow";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/PhotoNow";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public UserDTO getUserById(String userId) {
        UserDTO user = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM user WHERE user_id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new UserDTO();
                user.setUser_id(resultSet.getString("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRegistration_date(resultSet.getString("registration_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
