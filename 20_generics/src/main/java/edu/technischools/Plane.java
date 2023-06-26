package edu.technischools;

import java.util.ArrayList;
import java.util.List;

public class Plane implements Comparable<Plane> {
    private int speed;
    private int maxAltitude;
    private String name;

    public Plane(int speed, int maxAltitude, String name) {
        this.speed = speed;
        this.maxAltitude = maxAltitude;
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Plane otherPlane) {
        if (this.speed > otherPlane.speed) {
            return 1;
        } else if (this.speed < otherPlane.speed) {
            return -1;
        }
        return 0;
    }


}