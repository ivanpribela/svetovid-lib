package org.svetovid.demo;

import org.svetovid.io.Svetovid;

public class HelloWorld {

    public static void main(String[] args) {

        // Ask for a name
        String name = Svetovid.in.readString("Please enter your name: ");

        // Greet the user
        Svetovid.out.writeln("Hello " + name + "!");

    }
}
