package com.company;

import java.lang.*;

public class Heuristics {

    public static final int H_FIRST = 1;
    public static final int H_SECOND = 2;
    public static final int H_THIRD = 3;
    public static final int H_FOURTH = 4;
    public static final int H_FIFTH = 5;
    public static final int H_SIXTH = 6;

    int heuristicChoice;

    public Heuristics(int heuristicChoice) {
        this.heuristicChoice = heuristicChoice;
    }

    // finding the heuristic
    //finding the Manhattan distance\

    public int heuristicFunction(int choice, Coordinate current, Coordinate target) {
        // Choosing heuristic function
        switch(choice)
        {
            case H_FIRST:
                return 0;
            case H_SECOND:
                return minimumHeuristic(current, target);
            case H_THIRD:
                return maximumHeuristic(current, target);
            case H_FOURTH:
                return sumHeuristic(current, target);
            case H_FIFTH:
                return admissableHeuristic(current, target);
            case H_SIXTH:
                return nonadmissableHeuristic(current, target);

        }
        return 0;
    }

    public int findHorizontal(Coordinate current, Coordinate target) {
         return Math.abs(current.getX() - target.getX());
    }

    public int findVertical(Coordinate current, Coordinate target) {
        return Math.abs(current.getY() - target.getY());
    }

    public int minimumHeuristic(Coordinate current, Coordinate target) {
        return Math.min(findHorizontal(current, target), findVertical(current, target));
    }

    public int maximumHeuristic(Coordinate current, Coordinate target) {
        return Math.max(findHorizontal(current, target), findVertical(current, target));
    }

    public int sumHeuristic(Coordinate current, Coordinate target) {
        return findHorizontal(current, target) + findVertical(current, target);
    }

    public int admissableHeuristic(Coordinate current, Coordinate target) {
        return (int) Math.sqrt(Math.pow(findHorizontal(current, target), 2)
                + Math.pow(findVertical(current, target), 2));
    }

    public int nonadmissableHeuristic(Coordinate current, Coordinate target) {
        return 3 * admissableHeuristic(current, target);
    }

}

