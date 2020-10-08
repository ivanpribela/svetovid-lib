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

public class WeatherForecast {

    public static final String API_KEY = "";

    public static void main(String[] args) {

        // Ask for location
        String location = Svetovid.in.readLine("Display weather forecast for:");

        // Get the weather info from Open Weather Map
        // WARNING: since 2016 openweathermap.org requires an API key,
        // please register and acquire one, then set it in the API_KEY constant 
        String uri = "http://api.openweathermap.org/data/2.5/forecast?"
                + "units=metric&mode.json&q=" + location + "&appid=" + API_KEY;
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
        String format = "%s %8s, %4d%% clouds, %5.2f\u00b0C,%4d%% humidity, wind %.2fm/s %n";
        for (Object forecast : JsonHelper.getArray(data, "list")) {

            // Extract the data
            String time =        JsonHelper.getString(forecast, "dt_txt");
            String weather =     JsonHelper.getString(forecast, "weather[0].main");
            Number clouds =      JsonHelper.getNumber(forecast, "clouds.all");
            Number temperature = JsonHelper.getNumber(forecast, "main.temp");
            Number humidity =    JsonHelper.getNumber(forecast, "main.humidity");
            Number wind =        JsonHelper.getNumber(forecast, "wind.speed");

            Svetovid.out.printf(format,
                    time,
                    weather,
                    clouds.longValue(),
                    temperature.doubleValue(),
                    humidity.longValue(),
                    wind.doubleValue()
            );

        }

    }
}
