import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add_value")
public class AddValue extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("type") == null && request.getParameter("date") == null && request.getParameter("value") == null){
            request.setAttribute("message","Null value");
            request.getRequestDispatcher("add_value").forward(request, response);
        }
        Meter meter = MeterFactory.createMeter("electricity");
        try{
            if (meter != null) {
                meter.setValue(Double.parseDouble(request.getParameter("value")));
            }
        }catch (NumberFormatException e){
            request.setAttribute("message","Incorrect value");
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
        if (meter != null) {
            meter.setDate(request.getParameter("date"));
        }
        MeterDAO meterDAO = new MeterDAOImplemetation();
        meterDAO.insertMeter(meter, String.valueOf(session.getAttribute("username")));
        request.getRequestDispatcher("/electricity").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MeterDAO meterDAO = new MeterDAOImplemetation();
        request.setAttribute("types",meterDAO.selectTypes());
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
