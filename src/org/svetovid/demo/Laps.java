package org.svetovid.demo;

import org.svetovid.io.Svetovid;
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
        Svetovid.out.writeln("Time it took to enter individual numbers:");
        Svetovid.out.writeln(times);
        times = stopwatch.getTotalTimes();
        Svetovid.out.writeln("Total time it took before entering each number:");
        Svetovid.out.writeln(times);

    }
}
