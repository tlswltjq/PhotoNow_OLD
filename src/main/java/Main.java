import BEANS.UserDTO;
import DAO.UserDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO da = new UserDAO();
        UserDTO dt = new UserDTO("newUser", "신지섭", "123123", "wltjq1203@icloud.com");

        da.signUP(dt);
    }
}
