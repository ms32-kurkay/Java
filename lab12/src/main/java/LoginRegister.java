import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login_register")
public class LoginRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAOImplementation();
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        String loginSubmit = request.getParameter("login");
        String regSubmit = request.getParameter("reg");
        User user = userDAO.getUser(userName, password);
        if (loginSubmit!= null && user != null && user.getUsername() != null && user.getPassword() != null){
            HttpSession session = request.getSession();
            session.setAttribute("user_name",userName);
            response.sendRedirect("/main");
        }
        else if(regSubmit != null){
            if(userDAO.getUserName(userName)){
                request.setAttribute("message","Этот логин используется");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }
            if(userName.isEmpty() && password.isEmpty()){
                request.setAttribute("message","Не введены данные");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }
            user.setUsername(userName);
            user.setPassword(password);
            userDAO.insertUser(user);
            request.setAttribute("message","Регистрация прошла успешно, ввойдите");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            request.setAttribute("message","Нету такого пользователя");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
