import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLQueries {
    public static Statement statement;
    public static ResultSet resultSet;
    public static Connection connection = ConnectionManager.getConnection();

    public static List selectWeather(String region) {
        List<String> resultOfQuery = new ArrayList<>();
        String query = "SELECT " +
                "regions.region_name," +
                "countries.country_date," +
                "countries.temperature," +
                "countries.precipitation " +
                "FROM countries " +
                "JOIN regions ON countries.region_id= regions.id " +
                "WHERE regions.region_name='"+region.trim()+"';";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String name = resultSet.getString(1);
                String date = resultSet.getString(2);
                int temperature = resultSet.getInt(3);
                int precipitation = resultSet.getInt(4);
                resultOfQuery.add("Название региона: "+ name + ";\n" +
                        "Дата: " + date + ";\n " +
                        "Температура: " + temperature + "°C;\n" +
                        "Количство осадков : " + precipitation + "мм;");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultOfQuery;
    }

    public static List selectDate(String region, String minTemperature){
        List resultOfQuery = new ArrayList();
        String query = "SELECT regions.region_name," +
                "countries.country_date," +
                "countries.temperature," +
                "countries.precipitation " +
                "FROM countries " +
                "JOIN regions ON countries.region_id= regions.id " +
                "WHERE regions.region_name='"+region.trim()+"' AND " +
                "countries.temperature < "+minTemperature.trim()+" AND countries.precipitation > 0;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString(1);
                String date = resultSet.getString(2);
                int temperature = resultSet.getInt(3);
                int precipitation = resultSet.getInt(4);
                resultOfQuery.add("Название региона: "+ name + ";\n" +
                        "Дата: " + date + ";\n " +
                        "Температура: " + temperature + "°C;\n" +
                        "Количство осадков : " + precipitation + "мм;");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultOfQuery;
    }

    public static List selectWeekWeather(String language){
        List<String> resultOfQuery = new ArrayList<>();
        String query = "SELECT regions.region_name," +
                "countries.country_date," +
                "populations.population_language," +
                "countries.temperature," +
                "countries.precipitation " +
                "FROM countries " +
                "JOIN regions ON countries.region_id = regions.id " +
                "JOIN populations ON populations.id = regions.population_id " +
                "WHERE countries.country_date BETWEEN CURRENT_DATE() - INTERVAL 14 DAY AND CURRENT_DATE() - INTERVAL 7 DAY "+
                "AND populations.population_language='"+language.trim()+"';";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString(1);
                String date = resultSet.getString(2);
                language = resultSet.getString(3);
                int temperature = resultSet.getInt(4);
                int precipitation = resultSet.getInt(5);
                resultOfQuery.add("Название региона: "+ name + ";\n" +
                        "Дата: " + date + ";\n " +
                        "Язык населения: " + language + ";\n" +
                        "Температура: " + temperature + "°C;\n" +
                        "Количство осадков : " + precipitation + "мм;");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultOfQuery;
    }

    public static String selectTemperature(String area){
        String resultOfQuery = "";
        String query="SELECT countries.temperature " +
                "FROM countries " +
                "JOIN regions ON countries.region_id = regions.id " +
                "WHERE regions.region_area > " + area +
                " AND countries.country_date BETWEEN current_date() - interval 14 day and current_date() - interval 7 day " +
                "ORDER BY regions.region_name;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            double sum = 0;
            int count = 0;
            while (resultSet.next()){
                double temperature = resultSet.getInt(1);
                sum += temperature;
                count += 1;
                if(resultSet.isLast())
                    resultOfQuery = "Средняя температура за неделю: " + (sum/count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultOfQuery;
    }
}
