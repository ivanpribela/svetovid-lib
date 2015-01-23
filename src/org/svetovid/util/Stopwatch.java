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

package org.svetovid.util;

import java.util.ArrayList;
import java.util.List;

public class Stopwatch {

    private long startTime;
    private long pauseTime;
    private long lapTime;
    private long pauseLength;
    private long lapPauseLength;
    private int timesPaused;
    private List<Long> laps = new ArrayList<>();

    public Stopwatch() {
        this(true);
    }

    public Stopwatch(boolean autoStart) {
        startTime = System.currentTimeMillis();
        pauseTime = startTime;
        lapTime = startTime;
        pauseLength = 0;
        lapPauseLength = 0;
        timesPaused = 0;
        if (!autoStart) {
            timesPaused++;
        }
    }

    public void pause() {
        if (timesPaused == 0) {
            pauseTime = System.currentTimeMillis();
        }
        timesPaused++;
    }

    public void resume() {
        if (timesPaused > 0) {
            timesPaused--;
            if (timesPaused == 0) {
                pauseLength = pauseLength + (System.currentTimeMillis() - pauseTime);
                lapPauseLength = lapPauseLength + (System.currentTimeMillis() - pauseTime);
            }
        }
    }

    public boolean isPaused() {
        return timesPaused > 0;
    }

    public double time() {
        long now = isPaused() ? pauseTime : System.currentTimeMillis();
        long time = now - startTime - pauseLength;
        return time / 1000.0;
    }

    public double lap() {
        long now = isPaused() ? pauseTime : System.currentTimeMillis();
        long time = now - lapTime - lapPauseLength;
        lapTime = now;
        lapPauseLength = 0;
        laps.add(time);
        return time / 1000.0;
    }

    public double[] getLapTimes() {
        int n = laps.size();
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = laps.get(i) / 1000.0;
        }
        return result;
    }

    public double[] getTotalTimes() {
        int n = laps.size();
        long sum = 0;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            sum = sum + laps.get(i);
            result[i] = sum / 1000.0;
        }
        return result;
    }
}
