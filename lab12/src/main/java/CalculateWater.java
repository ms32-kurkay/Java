import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate_water")
public class CalculateWater extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double subTariff = 1.3856;
        double fullTariff = 1.3888;
        try{
            double result = 0;
            int persons = Integer.parseInt(request.getParameter("persons"));
            if(persons < 1){
                request.setAttribute("message","Непраильное значение количества людей");
                request.getRequestDispatcher("/calculate_water.jsp").forward(request, response);
            }else{
                double value = Double.parseDouble(request.getParameter("value"));
                String subRadio = request.getParameter("sub_t");
                String fullRadio = request.getParameter("full_t");
                String noRadio = request.getParameter("no_t");
                if(subRadio != null)
                    result = subTariff * value;
                if(fullRadio != null)
                    result = fullTariff * value;
                if(noRadio != null){
                    double normal = 0.14*30*persons;
                    result = (value-normal)*fullTariff + normal*subTariff;
                }
                request.setAttribute("result","Результат: " + result);
                request.getRequestDispatcher("/calculate_water.jsp").forward(request, response);
            }
        }catch (NumberFormatException e){
            request.setAttribute("message","Incorrect value");
            request.getRequestDispatcher("/calculate_electricity.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/calculate_water.jsp").forward(request, response);
    }
}
