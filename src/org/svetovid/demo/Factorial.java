package org.svetovid.demo;

import org.svetovid.io.Svetovid;
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
