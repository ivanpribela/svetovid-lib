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

public class GasNeeded {

    public static void main(String[] args) {

        // Ask for data
        double distance = Svetovid.in.readDouble("What is the distance in kilometers?");
        double usage = Svetovid.in.readDouble("How many kilometres can your car travel per liter of gas?");

        // Calculate the gas needed
        double needed = distance / usage;
        Svetovid.out.println("You will need", needed, "liters of gas for your journey.");

    }
}
