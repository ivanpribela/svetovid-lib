package org.svetovid.demo;

import org.svetovid.Svetovid;

public class MaxArray {

    public static void main(String[] args) {

        // Ask for an array of numbers
        double[] numbers = Svetovid.in.readDoubleLine("Please enter the numbers: ");

        // Find the maximum
        double maximum = Double.NEGATIVE_INFINITY;
        for (double number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }

        // Print the result
        Svetovid.out.writeln("Maximum number:", maximum);
        Svetovid.out.writeln(numbers);

    }
}
