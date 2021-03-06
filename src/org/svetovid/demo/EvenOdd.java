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

public class EvenOdd {

    public static void main(String[] args) {

        // Ask for an array of numbers
        int[] numbers = Svetovid.in.readIntArray("Please enter the numbers:");

        // Find odd numbers
        Svetovid.out.print("Odd numbers are:");
        for (int number : numbers) {
            if (number % 2 == 1) {
                Svetovid.out.print();
                Svetovid.out.print(number);
            }
        }
        Svetovid.out.println();

        // Find even numbers
        Svetovid.out.print("Even numbers are:");
        for (int number : numbers) {
            if (number % 2 == 0) {
                Svetovid.out.print();
                Svetovid.out.print(number);
            }
        }
        Svetovid.out.println();

    }
}
