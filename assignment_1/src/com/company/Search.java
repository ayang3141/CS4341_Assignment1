package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Search {
    // This class holds search algorithms for the board, in particularly, the A* Search Algorithm

    Board gameboard;
    Agent agent;
    PriorityQueue<State> StateComparator = new PriorityQueue<State>(new Comparator<State>() {
        @Override
        public int compare(State s1, State s2) {return s1.getPriorityValue() - s2.getPriorityValue();}
    });

    // Constructor for the Search class
    public Search(Board gameBoard, Agent agent) {
        this.gameboard = gameBoard;
        this.agent = agent;
    }

    // This method searches the board using the A* Algorithm
    public State A_Star_Search() {
        // Priority queue for Coordinates to visit
        PriorityQueue<State> OPEN = new PriorityQueue<State>(StateComparator);
        Coordinate startPoint = this.gameboard.getStartPoint();
        State start_state = new State(startPoint);

        // set previous node of start to null, and current path cost of start to 0
        start_state.came_from = null;
        start_state.currentCost = 0;

        // Adds start_point to priority queue
        OPEN.add(start_state);



        // while there are still states to be visited ...
        while(OPEN.size() != 0) {
            // get state with most priority
            State current = OPEN.remove();

            // if goal is reached, return path
            if(gameBoard[current.getX()][current.getY()] == 'G') {
                return current;
            }

            // TODO, create function to get next states
            State[] NextState = gameBoard.getNeighbors(current);

            // for each next_state
            for(int i = 0; i < NextState.length; i++) {
                // calculate the updated cost of the state
                int new_cost = current.currentCost + moveCost(current, NextState[i]);

                // if the next state does not have a current cost, or
                // if the new cost is less than the old cost, update
                if((NextState[i].getCurrentCost() == -1)
                        || (new_cost < NextState[i].getCurrentCost())){
                    NextState[i].currentCost = new_cost;
                    NextState[i].priorityValue = new_cost + heuristic(goal, NextState[i]);
                    OPEN.add(NextState[i]);
                    NextState[i].came_from = current;
                }

            }

        }


        return null;
    }
}
