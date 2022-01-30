package com.company;

public class State {
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    public static final int EAST = 4;
    // This class is used to hold important information about the state of the agent

    Coordinate position;
    int faceDirection;
    int priorityValue;
    int currentCost;
    String previousMove;

    // Constructor for the State class
    public State(Coordinate coordinates, int faceDirection) {
        this.position = coordinates;
        this.faceDirection = faceDirection;
        this.priorityValue = Integer.MAX_VALUE;
        this.currentCost = -1;
    }

    public State(Coordinate coordinates, int faceDirection, String previousMove) {
        this.position = coordinates;
        this.faceDirection = faceDirection;
        this.priorityValue = Integer.MAX_VALUE;
        this.currentCost = -1;
        this.previousMove = previousMove;
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

    public Coordinate getCoordinate() { return position; }

    public void setFaceDirection(int faceDirection) { this.faceDirection = faceDirection; }







}
