package DAO;

public class User {
    private String name;
    private String email;
    private String id;
    private String password;
    public User(){}
//    public DAO.User(String name, String email, String id, String password) {
//        this.name = name;
//        this.email = email;
//        this.id = id;
//        this.password = password;
//    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "DAO.User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
