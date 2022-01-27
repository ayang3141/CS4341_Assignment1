package com.company;

public class State {
    int x;
    int y;
    int faceDirection;
    int priorityValue;
    int currentCost;
    State came_from;

    public(int x, int y, int faceDirection, int priority, State parent) {
        this.x = x;
        this.y = y;
        this.faceDirection = faceDirection;
        this.priorityValue = priority;
        this.currentCost = -1;
        this.came_from = came_from;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFaceDirection() {
        return faceDirection;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    public State getCame_from() {
        return came_from;
    }






}
