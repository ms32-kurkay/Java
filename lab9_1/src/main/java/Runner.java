import com.google.gson.Gson;
import values.AreaData;

import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;


public class Runner {
    private static final String CITY = "Phoenix,us";
        private static final String API = "e240c98ecd59c6bc45495e4a933384db";
    private static final String PATH_JSON = "src/main/resources/info.json";
    private static final String PATH_HTML = "src/main/resources/info.html";
    private static final String PATTERN_NUMBER = "#0.00";

    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    public static void main(String[] args) throws IOException {
            String url = "http://api.openweathermap.org/data/2.5/weather?q="+ CITY +
                "&APPID=" + API;
        downloadUsingStream(url, PATH_JSON);
        FileReader fileReader = new FileReader(PATH_JSON);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        AreaData areaData;
        Gson gson = new Gson();
        areaData = gson.fromJson(bufferedReader, AreaData.class);
        String city = areaData.getName() + "," + areaData.getSys().getCountry() +  "(" + areaData.getSys().getId() + ")";
        String icon = "http://openweathermap.org/img/w/" + areaData.getWeather().get(0).getIcon() + ".png'";
        String weather = areaData.getWeather().get(0).getMain() + "." + areaData.getWeather().get(0).getDescription();
        String temperature = new DecimalFormat(PATTERN_NUMBER).format(areaData.getMain().getTemp() - 273.15);
        String pressure = new DecimalFormat(PATTERN_NUMBER).format((areaData.getMain().getPressure() * 0.75));
        String humidity = String.valueOf(areaData.getMain().getHumidity());
        String minTemp = new DecimalFormat().format((areaData.getMain().getTemp_min() - 273.15));
        String maxTemp = new DecimalFormat().format((areaData.getMain().getTemp_max() - 273.15));
        String wind = new DecimalFormat(PATTERN_NUMBER).format(areaData.getWind().getSpeed());
        String windDirection = "";
        if(areaData.getWind().getDeg() > 0 && areaData.getWind().getDeg() < 22.5)
            windDirection = "N";
        else if(areaData.getWind().getDeg() > 22.5 && areaData.getWind().getDeg() < 67.5)
            windDirection = "NE";
        else if(areaData.getWind().getDeg() > 67.5 && areaData.getWind().getDeg() < 112.5)
            windDirection = "E";
        else if(areaData.getWind().getDeg() > 112.5 && areaData.getWind().getDeg() < 157.5)
            windDirection = "SE";
        else if(areaData.getWind().getDeg() > 157.5 && areaData.getWind().getDeg() < 202.5)
            windDirection = "S";
        else if(areaData.getWind().getDeg() > 202.5 && areaData.getWind().getDeg() < 247.5)
            windDirection = "SW";
        else if(areaData.getWind().getDeg() > 247.5 && areaData.getWind().getDeg() < 292.5)
            windDirection = "W";
        else if(areaData.getWind().getDeg() > 292.5 && areaData.getWind().getDeg() < 337.5)
            windDirection = "NW";
        else if(areaData.getWind().getDeg() > 337.5 && areaData.getWind().getDeg() < 360)
            windDirection = "N";
        String clouds = String.valueOf(areaData.getClouds().getAll());
        String page="<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <title>Weather</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>"+ city + "<img width='54' height='54' src='"+ icon + ">" + "</h2>" +
                "<div>"  + weather + "</div>" +
                "<div><br>Temperature: " + temperature + "°C</div>" +
                "<div>Pressure: " + pressure + " mmHg St</div>"+
                "<div>Humidity: " + humidity + "%</div>"+
                "<div>Min. temp: " + minTemp +
                    "; Max. temp: " + maxTemp + "</div>" +
                "<div>Wind : " + wind + " m/s " + windDirection + "</div>" +
                "<div>Clouds: "  + clouds + "%</div>" +
                "</body>\n" +
                "</html>";
        FileOutputStream fileOutputStream = new FileOutputStream(PATH_HTML);
        fileOutputStream.write(page.getBytes());
        fileOutputStream.close();
    }
}
