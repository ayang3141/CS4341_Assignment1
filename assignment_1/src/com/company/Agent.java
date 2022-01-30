package com.company;

import java.util.ArrayList;
import java.util.List;


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
//    increase or decrease score
//    list all available moves at position
public class Agent {

    Board board;

    // Constructor for the Agent class
    public Agent(Board board) {
        this.board = board;
    }

    // Get the coordinates of some number of spaces in front of the Agent
    public Coordinate getForwardSpace(State oldState, int numSpaces) {

        switch(oldState.getFaceDirection())
        {
            case State.NORTH:
                // if facing north, move two spaces north
                return new Coordinate(oldState.getX(), oldState.getY() - numSpaces);
            case State.SOUTH:
                // if facing south, move two spaces south
                return new Coordinate(oldState.getX(), oldState.getY() + numSpaces);
            case State.WEST:
                // if facing west, move two spaces west
                return new Coordinate(oldState.getX() - numSpaces, oldState.getY());
            case State.EAST:
                // if facing east, move two spaces east
                return new Coordinate(oldState.getX() + numSpaces, oldState.getY());
        }

        return null;
    }

    // This gets the forward state
    public State moveForward(State oldState) {

        //calculate forward space
        Coordinate forwardSpace = getForwardSpace(oldState, 1);

        //check if can more forwards
        if(checkSpace(forwardSpace))
        {
            //increment position forward
            return new State(forwardSpace, oldState.getFaceDirection());
        }
        return null;
    }

    // This gets the left state
    public State turnLeft(State oldState) {

        int oldStateFaceDirection = oldState.getFaceDirection();
        // determine new direction
        switch(oldStateFaceDirection)
        {
            case State.NORTH:
                // if north, face west
                return new State(oldState.getCoordinate(), State.WEST);
            case State.SOUTH:
                // if south, face east
                return new State(oldState.getCoordinate(), State.EAST);
            case State.WEST:
                // if west, face south
                return new State(oldState.getCoordinate(), State.SOUTH);
            case State.EAST:
                // if east, face north
                return new State(oldState.getCoordinate(), State.NORTH);
        }
        return null;
    }

    // This gets the right state
    public State turnRight(State oldState) {
        int oldStateFaceDirection = oldState.getFaceDirection();
        // determine new direction
        switch(oldStateFaceDirection)
        {
            case State.NORTH:
                // if north, face east
                return new State(oldState.getCoordinate(), State.EAST);
            case State.SOUTH:
                // if south, face west
                return new State(oldState.getCoordinate(), State.WEST);
            case State.WEST:
                // if west, face north
                return new State(oldState.getCoordinate(), State.NORTH);
            case State.EAST:
                // if east, face south
                return new State(oldState.getCoordinate(), State.SOUTH);
        }

        return null;
    }

    // This method makes the agent bash
    public State bash(State oldState) {

        //calculate forward space
        Coordinate bashSpace = getForwardSpace(oldState, 2);

        //check to see if we can actually move into that space
        if(checkSpace(bashSpace))
        {
            // increment twice
            return new State(bashSpace, oldState.getFaceDirection());
        }
        return null;
    }

    // This method checks if the coordinate is a valid position
    public boolean checkSpace(Coordinate coordinate) {
        if(board.OutOfBounds(coordinate)) {
            return false;
        }
        return true;
    }


    // This method retrieves a list of all valid agent moves from the given coordinate position
    // (Assume the agent cannot backtrack)
    public List<State> getNextStates(State oldState) {
        // list of available moves from a certain state
        List<State> newStateList = new ArrayList<>();

        // check if forward is possible, if so, add forward state
        if(checkSpace(getForwardSpace(oldState, 1))) {
            newStateList.add(moveForward(oldState));
        }

        // if previous move was left, only turn is left
        if(oldState.previousMove.equals("Left")) {
            newStateList.add(turnLeft(oldState));
        }
        // if previous move was right, only turn is right
        else if (oldState.previousMove.equals("Right")) {
            newStateList.add(turnRight(oldState));
        }

        // check if bash is possible, if so, add bash state
        if(checkSpace(getForwardSpace(oldState, 2))) {
            newStateList.add(bash(oldState));
        }

        return newStateList;
    }

    // This method calculates the cost of a certain move
    public int moveCost(State first, State second) {
        int cost = 0;

        String previousMove = second.previousMove;

        switch(previousMove) {
            case "forward":
                // if forward, get complexity of second state
                cost = board.getComplexity(second.getX(), second.getY());
                if(cost == 'G') { // if second state is goal, cost is only 1
                    cost = 1;
                }
                break;
            case "right":
                // if right, 1/2 of complexity of current state (rounded up)
                cost = (int) Math.ceil(0.5 * board.getComplexity(first.getX(), first.getY()));
                break;
            case "left":
                // if left, 1/2 of complexity of current state (rounded up)
                cost = (int) Math.ceil(0.5 * board.getComplexity(first.getX(), first.getY()));
                break;
            case "bash":
                // accounts for the bash cost and the proceeding forward cost
                cost = 3 + board.getComplexity(second.getX(), second.getY());
                break;
        }

        return cost;
    }


}