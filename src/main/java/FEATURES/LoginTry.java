package FEATURES;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginTry extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터 가져오기
        String username = request.getParameter("id");
        String password = request.getParameter("pw");

        // 간단한 로그인 검증 (예시로 username과 password가 "admin"일 때 로그인 성공으로 간주)
        boolean loginSuccess = "admin".equals(username) && "admin".equals(password);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Login Result</title></head>");
        out.println("<body>");

        if (loginSuccess) {
            out.println("<h1>Login Successful!</h1>");
            out.println("<p>Welcome, " + username + "!</p>");
        } else {
            out.println("<h1>Login Failed!</h1>");
            out.println("<p>Invalid username or password.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
