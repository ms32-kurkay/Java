import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/electricity")
public class ElectricityPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MeterDAO meterDAO = new MeterDAOImplemetation();
        String username = (String) session.getAttribute("username");
        List<Meter> meters = meterDAO.selectMeters(username, "electricity");
        request.setAttribute("meters",meters);
        getServletContext().getRequestDispatcher("/electricity.jsp").forward(request, response);
    }
}
