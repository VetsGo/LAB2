package org.example;

public class DVD extends Item{
    private int duration;

    public DVD(String title, int duration, String uniqueID) {
        super(title, uniqueID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}