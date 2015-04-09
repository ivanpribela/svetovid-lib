package org.svetovid.demo;

import org.svetovid.Svetovid;

public class WeatherForecast {

    public static void main(String[] args) {

        // Ask for location
        String location = Svetovid.in.readLine("Display weather forecast for:");

        // Get the weather info from Open Weather Map
        String uri = "http://api.openweathermap.org/data/2.5/forecast?"
                + "units=metric&mode.json&q=" + location;
        Object data = Svetovid.in(uri).readObject();

    }
}
