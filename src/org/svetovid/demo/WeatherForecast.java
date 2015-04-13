package org.svetovid.demo;

import org.svetovid.Svetovid;
import org.svetovid.util.JsonHelper;

public class WeatherForecast {

    public static void main(String[] args) {

        // Ask for location
        String location = Svetovid.in.readLine("Display weather forecast for:");

        // Get the weather info from Open Weather Map
        String uri = "http://api.openweathermap.org/data/2.5/forecast?"
                + "units=metric&mode.json&q=" + location;
        Object data = Svetovid.in(uri).readObject();

        // Were there errors?
        String code = JsonHelper.getString(data, "cod");
        if (!"200".equals(code)) {
            Svetovid.out.println("Error " + code);
            return;
        }

        // Print the forecast
        String name = JsonHelper.getString(data, "city.name");
        Svetovid.out.println("Weather forecast for " + name + ":");
        for (Object forecast : JsonHelper.getArray(data, "list")) {

            // Extract the data
            String time =        JsonHelper.getString(forecast, "dt_txt");
            String weather =     JsonHelper.getString(forecast, "weather[0].main");
            Number clouds =      JsonHelper.getNumber(forecast, "clouds.all");
            Number temperature = JsonHelper.getNumber(forecast, "main.temp");
            Number humidity =    JsonHelper.getNumber(forecast, "main.humidity");
            Number wind =        JsonHelper.getNumber(forecast, "wind.speed");

            // Print the weather information
            Svetovid.out.print(time);
            Svetovid.out.print(" " + weather + "\t");
            Svetovid.out.print(clouds + "% clouds\t");
            Svetovid.out.print(temperature + "\u00b0C,\t");
            Svetovid.out.print(humidity + "% humidity,\t");
            Svetovid.out.print("wind " + wind + " m/s");
            Svetovid.out.println();

        }

    }
}
