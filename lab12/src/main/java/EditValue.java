import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit_meter")
public class EditValue extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MeterDAO meterDAO = new MeterDAOImplemetation();
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            Meter meter = MeterFactory.createMeter(request.getParameter("type"));
            meter.setId(id);
            String value = request.getParameter("value");
            meter.setValue(Double.parseDouble(value));
            meter.setDate(request.getParameter("date"));
            ((MeterDAOImplemetation) meterDAO).updateMeter(meter);
            response.sendRedirect("/meters");
        }catch (NumberFormatException e){
            request.setAttribute("message","Неккоректные данные");
            Meter meter = ((MeterDAOImplemetation) meterDAO).selectMeter(id);
            request.setAttribute("meter", meter);
            getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MeterDAO meterDAO = new MeterDAOImplemetation();
        Meter meter = ((MeterDAOImplemetation) meterDAO).selectMeter(id);
        request.setAttribute("meter", meter);
        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
    }
}
