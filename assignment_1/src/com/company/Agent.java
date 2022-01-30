package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    // Constructor for the Agent class
    public Agent(Board board) {
        this.board = board;
    }


    //Get the coordinates of the space in front of the Agent
    public Coordinate getForwardSpace(State oldState, int numSpaces) {

        switch(oldState.getFaceDirection())
        {
            case State.NORTH:
                return new Coordinate(oldState.getX(), oldState.getY() - numSpaces);
            case State.SOUTH:
                return new Coordinate(oldState.getX(), oldState.getY() + numSpaces);
            case State.WEST:
                return new Coordinate(oldState.getX() - numSpaces, oldState.getY());
            case State.EAST:
                return new Coordinate(oldState.getX() + numSpaces, oldState.getY());
        }

        return null;
    }

    // This method moves the agent forward
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

    // This method turns the agent left
    public State turnLeft(State oldState) {

        int oldStateFaceDirection = oldState.getFaceDirection();
        // determine new direction
        switch(oldStateFaceDirection)
        {
            case State.NORTH:
                return new State(oldState.getCoordinate(), State.WEST);
            case State.SOUTH:
                return new State(oldState.getCoordinate(), State.EAST);
            case State.WEST:
                return new State(oldState.getCoordinate(), State.SOUTH);
            case State.EAST:
                return new State(oldState.getCoordinate(), State.NORTH);
        }
        return null;
    }

    // This method turns the agent right
    public State turnRight(State oldState) {
        int oldStateFaceDirection = oldState.getFaceDirection();
        // determine new direction
        switch(oldStateFaceDirection)
        {
            case State.NORTH:
                return new State(oldState.getCoordinate(), State.EAST);
            case State.SOUTH:
                return new State(oldState.getCoordinate(), State.WEST);
            case State.WEST:
                return new State(oldState.getCoordinate(), State.NORTH);
            case State.EAST:
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
        // return all the available moves from a certain position
        List<State> newStateList = new ArrayList<>();
        if(checkSpace(getForwardSpace(oldState, 1))) {
            newStateList.add(moveForward(oldState));
        }

        if(oldState.previousMove.equals("Left")) {
            newStateList.add(turnLeft(oldState));
        }
        else if (oldState.previousMove.equals("Right")) {
            newStateList.add(turnRight(oldState));
        }

        if(checkSpace(getForwardSpace(oldState, 2))) {
            newStateList.add(bash(oldState));
        }

        return newStateList;
    }

}