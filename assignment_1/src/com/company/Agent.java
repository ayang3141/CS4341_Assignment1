package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


// This class is purely responsible for the agent and what it should do
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
                return new Coordinate(oldState.getX() - numSpaces, oldState.getY());
            case State.SOUTH:
                // if facing south, move two spaces south
                return new Coordinate(oldState.getX() + numSpaces, oldState.getY() + numSpaces);
            case State.WEST:
                // if facing west, move two spaces west
                return new Coordinate(oldState.getX(), oldState.getY() - numSpaces);
            case State.EAST:
                // if facing east, move two spaces east
                return new Coordinate(oldState.getX(), oldState.getY() + numSpaces);
        }

        return null;
    }


    // Get the coordinates of some number of spaces in front of the Agent
    public Coordinate getBackwardSpace(State oldState) {

        switch(oldState.getFaceDirection())
        {
            case State.NORTH:
                // if facing north, move two spaces north
                return new Coordinate(oldState.getX() + 1, oldState.getY());
            case State.SOUTH:
                // if facing south, move two spaces south
                return new Coordinate(oldState.getX() - 1, oldState.getY());
            case State.WEST:
                // if facing west, move two spaces west
                return new Coordinate(oldState.getX(), oldState.getY() + 1);
            case State.EAST:
                // if facing east, move two spaces east
                return new Coordinate(oldState.getX(), oldState.getY() - 1);
        }

        return null;
    }


    public Coordinate getLeftSpace(State oldState) {

        switch(oldState.getFaceDirection())
        {
            case State.NORTH:
                // if facing north, turn west
                return new Coordinate(oldState.getX(), oldState.getY() - 1);
            case State.SOUTH:
                // if facing south, turn east
                return new Coordinate(oldState.getX(), oldState.getY() + 1);
            case State.WEST:
                // if facing west, turn south
                return new Coordinate(oldState.getX() + 1, oldState.getY());
            case State.EAST:
                // if facing east, turn north
                return new Coordinate(oldState.getX() - 1, oldState.getY());
        }

        return null;
    }

    public Coordinate getRightSpace(State oldState) {

        switch(oldState.getFaceDirection())
        {
            case State.NORTH:
                // if facing north, turn east
                return new Coordinate(oldState.getX(), oldState.getY() + 1);
            case State.SOUTH:
                // if facing south, turn west
                return new Coordinate(oldState.getX(), oldState.getY() - 1);
            case State.WEST:
                // if facing west, turn north
                return new Coordinate(oldState.getX() - 1, oldState.getY());
            case State.EAST:
                // if facing east, turn south
                return new Coordinate(oldState.getX() + 1, oldState.getY());
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
            State newState = new State(forwardSpace, oldState.getFaceDirection(), oldState.currentCost, oldState,"forward");
            int cost = moveCost(oldState, newState);
            newState.currentCost += cost;
            return newState;
        }
        return null;
    }

    public State moveLeft(State oldState) {
        if(checkSpace(getLeftSpace(oldState))) {

            State firstState = turnLeft(oldState);

            State secondState = moveForward(firstState);

            return secondState;
        }
        return null;
    }

    public State moveRight(State oldState) {
        if(checkSpace(getRightSpace(oldState))) {
            State firstState = turnRight(oldState);

            State secondState = moveForward(firstState);

            return secondState;
        }
        return null;
    }

    public State moveBackward(State oldState) {
        if(checkSpace(getBackwardSpace(oldState))) {
            State firstState = turnRight(oldState);

            State secondState = turnRight(firstState);

            State thirdState = moveForward(secondState);

            return thirdState;
        }
        return null;
    }

    // This gets the left state
    public State turnLeft(State oldState) {

        int oldStateFaceDirection = oldState.getFaceDirection();
        // determine new direction
        State newState;
        int cost;
        switch(oldStateFaceDirection)
        {

            case State.NORTH:
                // if north, face west
                newState = new State(oldState.getCoordinate(), State.WEST, oldState.currentCost, oldState, "left");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;
            case State.SOUTH:
                // if south, face east
                newState = new State(oldState.getCoordinate(), State.EAST, oldState.currentCost, oldState, "left");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;
            case State.WEST:
                // if west, face south
                newState = new State(oldState.getCoordinate(), State.SOUTH, oldState.currentCost, oldState,"left");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;
            case State.EAST:
                // if east, face north
                newState = new State(oldState.getCoordinate(), State.NORTH, oldState.currentCost, oldState,"left");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;
        }
        return null;
    }

    // This gets the right state
    public State turnRight(State oldState) {
        int oldStateFaceDirection = oldState.getFaceDirection();
        State newState;
        int cost;
        // determine new direction
        switch(oldStateFaceDirection)
        {
            case State.NORTH:
                // if north, face east
                newState = new State(oldState.getCoordinate(), State.EAST, oldState.currentCost, oldState,"right");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;
            case State.SOUTH:
                // if south, face west
                newState = new State(oldState.getCoordinate(), State.WEST, oldState.currentCost, oldState,"right");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;


            case State.WEST:
                // if west, face north
                newState = new State(oldState.getCoordinate(), State.NORTH, oldState.currentCost, oldState,"right");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;

            case State.EAST:
                // if east, face south
                newState = new State(oldState.getCoordinate(), State.SOUTH, oldState.currentCost, oldState,"right");
                cost = moveCost(oldState, newState);
                newState.currentCost += cost;
                return newState;

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
            //calculate forward space
            Coordinate firstSpace = getForwardSpace(oldState, 1);
            State firstState =  new State(firstSpace, oldState.getFaceDirection(), oldState.currentCost, oldState,"bash");
            int firstCost = moveCost(oldState, firstState);
            firstState.currentCost += firstCost;

            //calculate forward space
            Coordinate secondSpace = getForwardSpace(firstState, 1);
            State secondState =  new State(secondSpace, firstState.getFaceDirection(), firstState.currentCost, firstState,"forward");
            int secondCost = moveCost(firstState, secondState);
            secondState.currentCost += secondCost;
            return secondState;
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

        newStateList.add(turnLeft(oldState));
        newStateList.add(turnRight(oldState));
//        if(checkSpace(getLeftSpace(oldState))) {
//            newStateList.add(moveLeft(oldState));
//        }
//
//        if(checkSpace(getRightSpace(oldState))) {
//            newStateList.add(moveRight(oldState));
//        }

        // check if bash is possible, if so, add bash state
        if(checkSpace(getForwardSpace(oldState, 2))) {
            newStateList.add(bash(oldState));
        }

//        if(checkSpace(getBackwardSpace(oldState))) {
//            newStateList.add(moveBackward(oldState));
//        }

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
                else {
                    cost = Character.getNumericValue(cost);
                }
                break;
            case "right":
                // if right, 1/2 of complexity of current state (rounded up)
                if(board.getComplexity(first.getX(), first.getY()) == 'S') {
                    cost = 1;
                }
                else {
                    cost = (int)Math.ceil(0.5 * Character.getNumericValue(board.getComplexity(first.getX(), first.getY())));
                }
                break;
            case "left":
                // if left, 1/2 of complexity of current state (rounded up)
                if(board.getComplexity(first.getX(), first.getY()) == 'S') {
                    cost = 1;
                }
                else {
                    cost = (int) Math.ceil(0.5 * Character.getNumericValue(board.getComplexity(first.getX(), first.getY())));
                }
                break;
            case "bash":
                cost = 3;

                break;
        }

        return cost;
    }


}