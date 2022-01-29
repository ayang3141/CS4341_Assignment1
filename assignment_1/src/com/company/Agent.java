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

    Board board;
    State agent_state;
    int numNodesExpanded;
    int numActions;
    int score;

    // Constructor for the Agent class
    public Agent(Board board) {
        numNodesExpanded = 0;
        numActions = 0;
        score = 0;
        this.board = board;
        agent_state = new State(board.getStartPoint(), State.NORTH);
    }

    // This method moves the agent forward
    public void moveForward() {

        Coordinate forwardSpace;
        switch(agent_state.faceDirection)
        {
            case State.NORTH:
                forwardSpace = new Coordinate();
                break;
            case State.SOUTH:
                forwardSpace = new Coordinate();
                break;
            case State.WEST:
                forwardSpace = new Coordinate();
                break;
            case State.EAST:
                forwardSpace = new Coordinate();
                break;
            default:
                forwardSpace = new Coordinate();
                break;
        }
        if(checkSpace(forwardSpace))
        {
            //increment position forward
            //decrease score by terrain complexity of ForwardSpace
        }
    }

    // This method turns the agent left
    public void turnLeft() {
        // turn the robot to face left
        // decrease score by 1/2 of terrain complexity (round up)
    }

    // This method turns the agent right
    public void turnRight() {
        // turn the robot to face right
        // decrease score by 1/2 of terrain complexity (round up)
    }

    // This method makes the agent bash
    public void bash() {
        if(checkSpace(ForwardSpace)
                && checkSpace(ForwardSpace + 1)) {
            // increment position forward
            // decrease score by 3
            // increment position forward
            // decrease score by terrain complexity of (ForwardSpace + 1)
        }
    }

    // This method checks if the coordinate is a valid position
    public boolean checkSpace(Coordinate coordinate) {
        if(board.OutOfBounds(coordinate)) {
            return false;
        }
        return true;
    }

    // This method increases the numNodesExpanded counter by a certain amount
    public void increaseNumNodesExpanded(int amount) {
        this.numNodesExpanded += amount;
    }

    // This method increments the numActions counter
    public void incrementNumActions() {
        this.numActions += 1;
    }

    // This method increases the agent score by a certain amount
    public void increaseScore(int amount) {
        this.score += amount;
    }

    // This method decreases the agent score by a certain amount
    public void decreaseScore(int amount) {
        this.score -= amount;
    }

    // This method retrieves a list of all valid agent moves from the given coordinate position
    // (Assume the agent cannot backtrack)
    public String[] getAvailableMoves(Coordinate position) {
        // return all the available moves from a certain position
        return null;
    }

}