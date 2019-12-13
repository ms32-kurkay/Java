import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/edit_meter")
public class EditServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Meter meter = new Meter();
//        meter.setId(Integer.parseInt(request.getParameter("id")));
//        meter.setType(request.getParameter("type"));
//        String value = request.getParameter("value");
//        try{
//            meter.setValue(Double.parseDouble(value));
//        }catch (NumberFormatException e){
//            request.setAttribute("message","Incorrect value");
//            request.getRequestDispatcher("edit.jsp").forward(request, response);
//        }
//        meter.setDate(request.getParameter("date"));
//    }
//        //request.getRequestDispatcher("index.jsp").forward(request, response);
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Meter meter = MeterDAOImplemetation.selectMeter(id);
//        request.setAttribute("meter", meter);
//        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
//
//    }
}
