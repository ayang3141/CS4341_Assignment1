package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Agent {
    // This class is purely responsible for the agent and what it should do
    // The agent should only be able to do the following:
    //    forward
    //    left
    //    right
    //    bash
    //    checkPosition
    //    nextMoves
    //    increase number of nodes expanded
    //    increment number of actions
    //    increase or decrase score
    //    list all available moves at position





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

    public void increaseNumNodesExpanded(int amount) {
        this.numNodesExpanded += amount;
    }

    public void incrementNumActions() {
        this.numActions += 1;
    }

    public void increaseScore(int amount) {
        this.score += amount;
    }

    public void decreaseScore(int amount) {
        this.score -= amount;
    }

    public String[] getAvailableMoves(Coordinate position) {
        // return all the available moves from a certain position
        return null;
    }

}