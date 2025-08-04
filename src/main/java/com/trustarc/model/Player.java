package com.trustarc.model;

public class Player {
    public String name;
    public String school;

    public Player(String name, String school) {
        this.name = name;
        this.school = school;
    }

    @Override
    public String toString() {
        return name + " (" + school + ")";
    }
}
