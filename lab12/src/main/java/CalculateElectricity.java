import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate_electricity")
public class CalculateElectricity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double withPlate = 0.1484;
        double withoutPlate = 0.1746;
        double fullTarriff = 0.1921;
        try{
            if(request.getParameter("value").trim().isEmpty()){
                request.setAttribute("message","Пустое значение");
                request.getRequestDispatcher("/calculate_electricity.jsp").forward(request, response);
            }else{
                double value = Double.parseDouble(request.getParameter("value"));
                String plateCheckBox = request.getParameter("el_plate");
                String fullCheckBox = request.getParameter("full");
                double result = 0;
                if(fullCheckBox != null)
                    result = value*fullTarriff;
                else if(plateCheckBox == null)
                    result = value*withoutPlate;
                else
                    result = value*withPlate;
                request.setAttribute("result","Результат: " + result);
                request.getRequestDispatcher("/calculate_electricity.jsp").forward(request, response);
            }
        }catch (NumberFormatException e){
            request.setAttribute("message","Некорректные данные");
            request.getRequestDispatcher("/calculate_electricity.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/calculate_electricity.jsp").forward(request, response);
    }
}
