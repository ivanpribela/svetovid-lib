/*
 * Copyright 2015 Ivan Pribela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.svetovid.demo;

import org.svetovid.Svetovid;
import org.svetovid.util.JsonHelper;

public class WeatherConditions {

    public static final String API_KEY = "";

    public static void main(String[] args) {

        // Ask for location
        String location = Svetovid.in.readLine("Display current weather conditions for:");

        // Get the weather info from Open Weather Map
        // WARNING: since 2016 openweathermap.org requires an API key,
        // please register and acquire one, then set it in the API_KEY constant 
        String uri = "http://api.openweathermap.org/data/2.5/weather?"
                + "units=metric&mode.json&q=" + location + "&appid=" + API_KEY;
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
