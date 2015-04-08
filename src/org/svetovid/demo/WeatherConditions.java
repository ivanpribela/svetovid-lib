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

        // Were there errors?
        String error = JsonHelper.getString(data, "message");
        if (error != null) {
            Svetovid.out.println(error);
            return;
        }

        // Extract the data
        String name =        JsonHelper.getString(data, "name");
        String weather =     JsonHelper.getString(data, "weather[0].main");
        Number clouds =      JsonHelper.getNumber(data, "clouds.all");
        Number temperature = JsonHelper.getNumber(data, "main.temp");
        Number humidity =    JsonHelper.getNumber(data, "main.humidity");
        Number pressure =    JsonHelper.getNumber(data, "main.pressure");
        Number wind =        JsonHelper.getNumber(data, "wind.speed");

        // Print the weather information
        Svetovid.out.println("   Location:", name);
        Svetovid.out.println("    Weather:", weather);
        Svetovid.out.println("     Clouds:", clouds + "%");
        Svetovid.out.println("Temperature:", temperature + "\u00b0C");
        Svetovid.out.println("   Humidity:", humidity + "%");
        Svetovid.out.println("   Pressure:", pressure + " hPa");
        Svetovid.out.println("       Wind:", wind + " m/s");

    }
}
