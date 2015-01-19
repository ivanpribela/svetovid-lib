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

public class Factorial {

    public static void main(String[] args) {

        // Ask for n
        int n = Svetovid.in.readInt("Factorial of which number would you like me to calculate? ");

        // Start the calculation timing
        Stopwatch stopwatch = new Stopwatch();

        // Calculate the factorial
        long factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial = i * factorial;
        }

        // Print the result
        double time = stopwatch.time();
        Svetovid.out.writeln("The factorial is:", factorial);
        Svetovid.out.writeln("It took", time, "seconds to calculate");

    }
}
