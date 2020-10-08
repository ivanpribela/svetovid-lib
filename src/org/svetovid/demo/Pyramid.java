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

public class Pyramid {

    public static void main(String[] args) {

        // Ask for the pyramid size
        int size = Svetovid.in.readInt("Please enter the size of the pyramid:");

        // Draw the pyramid layer by layer
        for (int i = 1; i <= size; i++) {

            // Add some space to center the pyramid
            for (int j = 0; j < size - i; j++) {
                Svetovid.out.print(" ");
            }

            // Draw the pyramid layer
            for (int j = 0; j < i; j++) {
                Svetovid.out.print(" *");
            }

            // Next layer
            Svetovid.out.println();

        }

    }
}
