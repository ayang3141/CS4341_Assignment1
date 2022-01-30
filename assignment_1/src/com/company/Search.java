package com.company;

import java.util.*;
import java.lang.Math;

public class Search {
    // This class holds search algorithms for the board, in particularly, the A* Search Algorithm

    Board gameBoard;
    Agent agent;
    PriorityQueue<State> StateComparator = new PriorityQueue<State>(new Comparator<State>() {
        @Override
        public int compare(State s1, State s2) {return s1.getPriorityValue() - s2.getPriorityValue();}
    });

    // Constructor for the Search class
    public Search(Board gameBoard, Agent agent) {
        this.gameBoard = gameBoard;
        this.agent = agent;
    }

    // This method searches the board using the A* Algorithm
    public void A_Star_Search() {
        // -------------------- INITIALIZATION ------------------
        // Initializes important counters and data structures
        int numNodesExpanded = 0;
        int numActions = 0;
        int score = 0;
        List<State> stateList = new ArrayList<>();
        PriorityQueue<State> OPEN = new PriorityQueue<State>(StateComparator);


        // Initialize matrix of cost_so_far for each state
        int numRows = this.gameBoard.getRows();
        int numCols = this.gameBoard.getCols();
        State[][][] best_states = new State[numRows][numCols][4];

        // ---------- PREPPING THE START STATE ----------------
        // Retrieve the start state of the agent
        Coordinate startPoint = this.gameBoard.getStartPoint();
        State start_state = new State(startPoint);
        start_state.came_from = null; // Set previous node of start to null
        start_state.currentCost = 0; // and current path cost of start to 0
        start_state.previous_move = null; // and the previous move to null
        best_states[start_state.getX()][start_state.getY()][start_state.getFaceDirection()] = start_state;

        // Adds start_point to priority queue
        OPEN.add(start_state);

        // while there are still states to be visited ...
        while(OPEN.size() != 0) {
            // Look at state with most priority
            State current = OPEN.remove();

            // If goal is reached, return path
            if(this.gameBoard.gameboard[current.getX()][current.getY()] == 'G') {

                while(current.came_from != null) {
                    stateList.add(current.came_from);
                    State temp = current.came_from;
                    current = temp;
                }
                Collections.reverse(stateList);

                break;
            }

            // TODO, create function to get next states, use constructor with previous move
            List<State> NextState = agent.getNextStates(current);
            // increment the number of nodes expanded
            numNodesExpanded++;

            // for each next_state
            for(int i = 0; i < NextState.size(); i++) {
                // Calculate the cost of the state
                int new_cost = current.currentCost + moveCost(current, NextState[i]);
                // update the cost of the new state
                NextState[i].currentCost = new_cost;
                // determine the priority of the new state
                NextState[i].priorityValue = new_cost + heuristic(goal, NextState[i]);
                // set current to be the parent of the new state
                NextState[i].came_from = current;
                // Add new state to the priority queue
                OPEN.add(NextState[i]);
            }

        } // end of the while loop


        // Calculate the score of the path
        for(int i = 1; i < stateList.size()-1; i++) {
            State currentState = stateList.get(i);
            String currentMove = currentState.previousMove;
            if(currentMove.equals("Forward")) {
                if(gameBoard.gameboard[currentState.getX()][currentState.getY()] == 'G') {
                    score -= 1;
                }
                score -= (int)gameBoard.gameboard[currentState.getX()][currentState.getY()];
            }
            else if(currentMove.equals("Left") || currentMove.equals("Right")) {
                score -= Math.ceil(0.5 * (int)gameBoard.gameboard[currentState.getX()][currentState.getY()]);
            }
            else if(currentMove.equals("Bash")) {
                score -= 3;
            }
            numActions++;

        }
        score += 100;

        System.out.println("Score of the path: " + score);
        System.out.println("Number of actions: " + numActions);
        System.out.println("Number of nodes expanded: " + numNodesExpanded);

        for(int i = 1; i < stateList.size()-1; i++) {
            System.out.println(stateList.get(i).previousMove);
        }
    }
}
