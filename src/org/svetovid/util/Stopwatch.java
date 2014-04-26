package org.svetovid.util;

public class Stopwatch {

    private long startTime;
    private long pauseTime;
    private long pauseLength;
    private int timesPaused;

    public Stopwatch() {
        this(true);
    }

    public Stopwatch(boolean autoStart) {
        startTime = System.currentTimeMillis();
        pauseTime = startTime;
        pauseLength = 0;
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
}
