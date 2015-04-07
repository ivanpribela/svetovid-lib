package org.svetovid.demo;

import org.svetovid.Svetovid;
import org.svetovid.util.JsonHelper;

public class WeatherConditions {

    public static void main(String[] args) {

        // Ask for location
        String location = Svetovid.in.readLine("Display current weather conditions for:");

        // Get the weather info from Open Weather Map
        String uri = "http://api.openweathermap.org/data/2.5/weather?"
                + "units=metric&mode.json&q=" + location;
        Object data = Svetovid.in(uri).readObject();

        // Extract the data
        String weather =     JsonHelper.getString(data, "weather[0].main");
        Number temperature = JsonHelper.getNumber(data, "main.temp");
        Number humidity =    JsonHelper.getNumber(data, "main.humidity");
        Number wind =        JsonHelper.getNumber(data, "wind.speed");

        // Print the weather information
        Svetovid.out.println("    Weather:", weather);
        Svetovid.out.println("Temperature:", temperature + "°C");
        Svetovid.out.println("   Humidity:", humidity + "%");
        Svetovid.out.println("       Wind:", wind + " m/s");

    }
}
