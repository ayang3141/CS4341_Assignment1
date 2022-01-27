package com.company;

public class State {
    // This class is used to hold important information about the state of the agent

    Coordinate position;
    int faceDirection;
    int priorityValue;
    int currentCost;
    State came_from;

    // Constructor for the State class
    public State(Coordinate coordinates, int faceDirection, int priority, State parent) {
        this.position = coordinates;
        this.faceDirection = faceDirection;
        this.priorityValue = Integer.MAX_VALUE;
        this.currentCost = -1;
        this.came_from = parent;
    }


    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
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
