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


    //Get the coordinates of the space in front of the Agent
    public Coordinate getForwardSpace(int numSpaces)
    {
        Coordinate forwardSpace = new Coordinate(0,0);
        switch(agent_state.getFaceDirection())
        {
            case State.NORTH:
                forwardSpace = new Coordinate(agent_state.getX(), agent_state.getY() - numSpaces);
                break;
            case State.SOUTH:
                forwardSpace = new Coordinate(agent_state.getX(), agent_state.getY() + numSpaces);
                break;
            case State.WEST:
                forwardSpace = new Coordinate(agent_state.getX() - numSpaces, agent_state.getY());
                break;
            case State.EAST:
                forwardSpace = new Coordinate(agent_state.getX() + numSpaces, agent_state.getY());
                break;
        }

        return forwardSpace;
    }

    // This method moves the agent forward
    public void moveForward() {

        //calculate forward space
        Coordinate forwardSpace = getForwardSpace(1);

        //check if can more forwards
        if(checkSpace(forwardSpace))
        {
            //increment position forward
            agent_state = new State(forwardSpace, agent_state.getFaceDirection());
        }
    }

    // This method turns the agent left
    public void turnLeft() {

        int new_faceDirection = agent_state.getFaceDirection();
        // determine new direction
        switch(agent_state.getFaceDirection())
        {
            case State.NORTH:
                new_faceDirection = State.WEST;
                break;
            case State.SOUTH:
                new_faceDirection = State.EAST;
                break;
            case State.WEST:
                new_faceDirection = State.SOUTH;
                break;
            case State.EAST:
                new_faceDirection = State.NORTH;
                break;
        }

        //create new state
        agent_state = new State(agent_state.getCoordinate(), new_faceDirection);
    }

    // This method turns the agent right
    public void turnRight() {
        int new_faceDirection = agent_state.getFaceDirection();
        // determine new direction
        switch(agent_state.getFaceDirection())
        {
            case State.NORTH:
                new_faceDirection = State.EAST;
                break;
            case State.SOUTH:
                new_faceDirection = State.WEST;
                break;
            case State.WEST:
                new_faceDirection = State.NORTH;
                break;
            case State.EAST:
                new_faceDirection = State.SOUTH;
                break;
        }

        //create new state
        agent_state = new State(agent_state.getCoordinate(), new_faceDirection);
    }

    // This method makes the agent bash
    public void bash() {
        //check to see if we can actually move into that space
        if(checkSpace(getForwardSpace(1))
                && checkSpace(getForwardSpace(2)))
        {
            // increment position forward
            moveForward();
            // increment position forward
            moveForward();
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
    //TODO: i think you are looking for a linkedlist for this
    public String[] getAvailableMoves(Coordinate position) {
        // return all the available moves from a certain position
        String availableMoves[];

        //availableMoves.

        return availableMoves;
    }

}