package com.protonmail.kschay.fitness_app.domain;

import java.util.Timer;
import java.util.TimerTask;

public class Rest {

    private final Timer timer;
    private final int duration;
    private int remainingTime;

    public Rest(int durationSeconds) {
        this.duration = durationSeconds;
        this.remainingTime = durationSeconds;
        this.timer = new Timer();
    }

    public void startCountdown() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (remainingTime > 0) {
                    System.out.println("Time remaining: " + remainingTime + " seconds");
                    remainingTime--;
                } else {
                    System.out.println("Time's up!");
                    timer.cancel(); // Stop the timer
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000); // Execute task every 1000ms (1 second)
    }

    public int getDuration() {
        return duration;
    }
}
