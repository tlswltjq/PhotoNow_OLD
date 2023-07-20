package DTO;

public class UserDTO {
    private String user_id;
    private String username;
    private String password;
    private String email;
    private String registration_date;

    public String getUser_id(){
        return user_id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getRegistration_date(){
        return registration_date;
    }
    public void setUser_id(String id){
        this.user_id = id;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email= email;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registration_date='" + registration_date + '\'' +
                '}';
    }
}
