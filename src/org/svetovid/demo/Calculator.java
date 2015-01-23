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

import org.svetovid.run.Start;

public class Calculator {

    public static class Inner {
        public int add(int a) {
            return a + 1;
        }
    }

    public double add(double a) {
        throw new RuntimeException("Missing an argument");
    }

    private double add(double a, double b) {
        return a + b;
    }

    public double add(double a, double b, double c) {
        return a + b + c;
    }

    public double minus(double a) {
        return -a;
    }

    protected String add(double a, String b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static void main(String[] arguments) {
        // Running this main method has the same result as using the Start class with the following arguments
        arguments = new String[] { "org.svetovid.demo.Calculator", "add", "6", "3" };
        Start.main(arguments);
        arguments = new String[] { "org.svetovid.demo.Calculator$Inner", "add", "6", "3" };
        Start.main(arguments);
    }
}
