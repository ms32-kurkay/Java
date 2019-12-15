import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add_value")
public class AddValue extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("type") == null && request.getParameter("date") == null && request.getParameter("value") == null){
            request.setAttribute("message","Нулевое значение");
            request.getRequestDispatcher("/add_value").forward(request, response);
        }
        String type = request.getParameter("type");
        Meter meter = MeterFactory.createMeter(type);
        try{
            meter.setValue(Double.parseDouble(request.getParameter("value")));
        }catch (NumberFormatException e){
            request.setAttribute("message","Неккоректные данные");
            request.getRequestDispatcher("/add.jsp").forward(request, response);
        }
        meter.setDate(request.getParameter("date"));
        MeterDAO meterDAO = new MeterDAOImplemetation();
        HttpSession session = request.getSession();
        String userName = String.valueOf(session.getAttribute("user_name"));
        meterDAO.insertMeter(meter, userName);
        response.sendRedirect("/meters");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
