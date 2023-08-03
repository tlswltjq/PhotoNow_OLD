package DAO;

import BEANS.UserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private static final String DB_URL = URLPath.Database.RemoteHost_MySQL.getUrl();
    private static final String DB_USERNAME = URLPath.Database.RemoteHost_MySQL.getUsername();
    private static final String DB_PASSWORD = URLPath.Database.RemoteHost_MySQL.getPassword();

    public UserDAO() {}

    public UserDTO getUserById(String userId) {
        UserDTO user = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM user WHERE user_id = ?";
//            String query = "SELECT * FROM user WHERE user_id like 'user%'";
//            멀티라인 쿼리 어떻게 저장할지도 생각해 보자.
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new UserDTO();
                user.setUserId(resultSet.getString("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRegistration_date(resultSet.getString("registration_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }//아이디를 이용해 유저정보 가져오기, 오버로딩을 통해 다른 데이터로 유저 정보 검색 해보자.

    //c회원가입             signUp
    public void signUP(UserDTO dt){
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            pstmt = conn.prepareStatement("INSERT INTO user (user_id, username, password, email, registration_date) VALUES(?, ?, ?, ?,NOW())");
            pstmt.setString(1, dt.getUserId());
            pstmt.setString(2, dt.getUsername());
            pstmt.setString(3, dt.getPassword());
            pstmt.setString(4, dt.getEmail());

            if (pstmt.executeUpdate()==1){
                System.out.println("OK");
            }else{
                System.out.println(":(");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//
//    //r회원정보가져오기     get_user
//    public UserDTO getUser(String id, String pwd){
//
//    }
//
    //u회원정보 갱신          update_user
    public void updateUser(UserDTO dt){
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            pstmt = conn.prepareStatement("UPDATE user SET username=?, password=?, email=? WHERE user_id= ?;");
            pstmt.setString(1,dt.getUsername());
            pstmt.setString(2,dt.getPassword());
            pstmt.setString(3,dt.getEmail());
            pstmt.setString(4,dt.getUserId());
            if(pstmt.executeUpdate()==1){
                System.out.println("Update Sucess");
            }else{
                System.out.println(":(");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //d회원탈퇴             signout
    public void signOut(String id, String password){
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            pstmt = conn.prepareStatement("delete from user where user_id=? and password = ?");
            pstmt.setString(1,id);
            pstmt.setString(2,password);
            if(pstmt.executeUpdate()==1){
                System.out.println("ByeBye" + id);
            }else{
                System.out.println(":(");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //로그인
    public int signIn(String userID, String userPW){
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            pstmt = conn.prepareStatement("SELECT password FROM user WHERE user_id =?");
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
        return -2;
    }
}
