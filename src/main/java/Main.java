import DAO.UserDAO;
import DTO.UserDTO;

public class Main {
    public static void main(String[] args) {
        UserDAO da = new UserDAO();
        UserDTO dt = new UserDTO();
        dt = da.getUserById("admin");
        System.out.println("dd");
        System.out.println(dt);
    }
}
