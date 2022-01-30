package com.company;

import java.lang.*;

public class Heuristics {

    Coordinate current;
    Coordinate target;
    int verticalDistance;
    int horizontalDistance;

    public Heuristics(Coordinate current, Coordinate target)
    {
        this.current= current;
        this.target= target;
        findVertical();
        findHorizontal();
    }
    // finding the heuristic
    //finding the Manhattan distance


    void findHorizontal()
    {
         horizontalDistance=Math.abs(current.x - target.x);    }

    int findVertical()
    {
       verticalDistance= Math.abs(current.y - target.y);
    }

    int minimumHeuristic()
    {
        return Math.min(this.verticalDistance,this.horizontalDistance);
    }

    int maximumHeuristic(int vertical,int horizontal)
    {
        return Math.max(this.verticalDistance,this.horizontalDistance);
    }

    int sumHeuristic()
    {
        return this.verticalDistance+this.horizontalDistance;
    }

    int admissableHeuristic()
    {
        return 0; // what should we do here
    }
    int nonadmissableHeuristic()
    {
        return admissableHeuristic()*3;
    }

}

