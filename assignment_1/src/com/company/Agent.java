package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Agent {
    // This class is purely responsible for the agent and what it should do
    // The agent should only be able to do the following:
    // forward, left, right, bash, checkPosition, nextMoves

    State agent_state;
    int numNodesExpanded;
    int numActions;
    int score;
    public Agent() {
        numNodesExpanded = 0;
        numActions = 0;
        score = 0;
    }

    public void moveForward() {
//        if(checkSpace(ForwardSpace)) {
//            increment position forward
//            decrease score by terrain complexity of ForwardSpace
//        }
    }

    public void turnLeft() {
        // turn the robot to face left
        // decrease score by 1/2 of terrain complexity (round up)
    }

    public void turnRight() {
        // turn the robot to face right
        // decrease score by 1/2 of terrain complexity (round up)
    }

    public void bash() {
        if(checkSpace(ForwardSpace)
                && checkSpace(ForwardSpace + 1)) {
            // increment position forward
            // decrease score by 3
            // increment position forward
            // decrease score by terrain complexity of (ForwardSpace + 1)
        }
    }

    public boolean checkSpace(Coordinate coordinate) {
        if(gameBoard.OutOfBounds(coordinate)) {
            return false;
        }
        return true;
    }




    public static void main(String[] args) {


    }

}