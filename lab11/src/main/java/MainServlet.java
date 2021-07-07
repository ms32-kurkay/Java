import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String region1 = req.getParameter("region1");
        String region2 = req.getParameter("region2");
        String temperature = req.getParameter("temp2");
        String language = req.getParameter("lang3");
        String area = req.getParameter("area4");

        req.setAttribute("value1",SQLQueries.selectWeather(region1));
        req.setAttribute("value2",SQLQueries.selectDate(region2, temperature));
        req.setAttribute("value3",SQLQueries.selectWeekWeather(language));
        req.setAttribute("value4",SQLQueries.selectTemperature(area));

        getServletContext().getRequestDispatcher("/output.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/input.jsp").forward(req,resp);
    }
}

