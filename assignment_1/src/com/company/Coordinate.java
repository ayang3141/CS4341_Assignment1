package com.company;


public class Coordinate {
    // This class is used to represent the coordinates on the board

    int x;
    int y;

    // Constructor for the Coordinate class
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // This method sets the X coordinate to the new value
    public void setX(int newX) {
        this.x = newX;
    }

    // This method sets the Y coordinate to the new value
    public void setY(int newY) {
        this.y = newY;
    }

    // This method retrieves the X coordinate
    public int getX() {
        return x;
    }

    // This method retrieves the Y coordinate
    public int getY() {
        return y;
    }



}
