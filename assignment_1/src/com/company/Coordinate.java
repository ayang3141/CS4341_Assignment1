package com.company;

public class Coordinate {
    int x;
    int y;
    char complexity;
    int priority;
    public Coordinate(int x_value, int y_value, char value, int priority) {
        this.x = x_value;
        this.y = y_value;
        this.complexity = value;
        this.priority = priority;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getComplexity() {
        return complexity;
    }

    public int getPriority() {
        return priority;
    }
}
