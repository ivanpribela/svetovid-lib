package org.svetovid.demo;

import org.svetovid.Svetovid;

public class GasNeeded {

    public static void main(String[] args) {

        // Ask for data
        double distance = Svetovid.in.readDouble("What is the distance in kilometers? ");
        double usage = Svetovid.in.readDouble("How many kilometres can your car travel per liter of gas? ");

        // Calculate the gas needed
        double needed = distance / usage;
        Svetovid.out.writeln("You will need", needed, "liters of gas for your journey.");

    }
}
