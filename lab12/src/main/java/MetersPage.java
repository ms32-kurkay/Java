import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/meters")
public class MetersPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MeterDAO meterDAO = new MeterDAOImplemetation();
        HttpSession session = request.getSession();
        String userName = String.valueOf(session.getAttribute("user_name"));
        List<Meter> meters = meterDAO.selectMeters(userName);
        request.setAttribute("meters",meters);
        getServletContext().getRequestDispatcher("/table_meters.jsp").forward(request, response);
    }
}
