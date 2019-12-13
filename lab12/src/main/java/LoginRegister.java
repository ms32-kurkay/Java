import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login_register")
public class LoginRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAOImplementation();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        session.setAttribute("username", username);
        String password = request.getParameter("password");
        String submitType = request.getParameter("submit");
        User user = userDAO.getUser(username, password);
        if (submitType.equals("Login") && user != null && user.getUsername() != null && user.getPassword() != null){
            response.sendRedirect("/main");
        }else if(submitType.equals("Register")){
            if(userDAO.getUserName(username)){
                request.setAttribute("message","this nickname is used");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }
            if(username.isEmpty() && password.isEmpty()){
                request.setAttribute("message","check form");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }
            user.setUsername(username);
            user.setPassword(password);
            userDAO.insertUser(user);
            request.setAttribute("message","registration done, login please");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            request.setAttribute("message","Data not founded, register please");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
