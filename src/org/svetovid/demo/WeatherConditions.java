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
        Svetovid.err.printObject(data);

    }
}
