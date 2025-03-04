package com.protonmail.kschay.fitness_app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.hibernate.annotations.UuidGenerator;

import java.util.Timer;
import java.util.TimerTask;

@Entity
@Table(name = "rest")
public class Rest implements IdentifiedEntity<String> {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;
    @Transient
    private final Timer timer;
    private final int duration;
    @Transient
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
