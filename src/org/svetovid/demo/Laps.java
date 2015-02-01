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
import org.svetovid.util.Stopwatch;

public class Laps {

    public static void main(String[] args) {

        // Start the stopwatch
        Stopwatch stopwatch = new Stopwatch();

        // Ask for numbers
        Double number;
        do {
            number = Svetovid.in.readDoubleBoxed("Enter a number [ENTER to stop]: ");
            stopwatch.lap();
        } while (number != null);

        // Print the statistics
        double[] times = stopwatch.getLapTimes();
        Svetovid.out.println("Time it took to enter individual numbers:");
        Svetovid.out.println(times);
        times = stopwatch.getTotalTimes();
        Svetovid.out.println("Total time it took before entering each number:");
        Svetovid.out.println(times);

    }
}
