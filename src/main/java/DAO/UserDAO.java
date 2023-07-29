package DAO;

import DTO.UserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final String DB_URL = URLPath.Database.RemoteHost_MySQL.getUrl();
    private static final String DB_USERNAME = URLPath.Database.RemoteHost_MySQL.getUsername();
    private static final String DB_PASSWORD = URLPath.Database.RemoteHost_MySQL.getPassword();

    public UserDAO() {

    }

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
    public int login(String userID, String userPW){
        String SQL =  "SELECT password FROM USER WHERE user_id =?";
        PreparedStatement pstmt;
        Connection conn;
        ResultSet rs;
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            if (rs.next()){
                if (rs.getString(1).equals(userPW)){
                    return 1;
                }
            }
            return -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
}
