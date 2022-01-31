package com.company;

import java.util.*;
import java.lang.Math;

public class Search {
    // This class holds search algorithms for the board, in particularly, the A* Search Algorithm

    Board gameBoard;
    Agent agent;
    int heuristic;
    PriorityQueue<State> StateComparator = new PriorityQueue<State>(new Comparator<State>() {
        @Override
        public int compare(State s1, State s2) {return s1.getPriorityValue() - s2.getPriorityValue();}
    });

    // Constructor for the Search class
    public Search(Board gameBoard, Agent agent, int heuristic) {
        this.gameBoard = gameBoard;
        this.agent = agent;
        this.heuristic = heuristic;
    }

    // This method searches the board using the A* Algorithm
    public void A_Star_Search() {
        // -------------------- INITIALIZATION ------------------
        // Initializes important counters and data structures
        int numNodesExpanded = 0;
        int numActions = 0;
        int score = 0;
        List<String> MoveList = new ArrayList<>();
        PriorityQueue<State> OPEN = new PriorityQueue<State>(StateComparator);
        Heuristics myHeuristic = new Heuristics(this.heuristic);

        // initialize the cost_so_far matrix
        int rows = this.gameBoard.numRows;
        int columns = this.gameBoard.numCols;
        State[][][] Best_States = new State[rows][columns][4];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                for(int k = 0; k < 4; k++) {
                    Coordinate currCoord = new Coordinate(i, j);
                    Best_States[i][j][k] = new State(currCoord, k, -1);
                }
            }
        }


        // ---------- PREPPING THE START STATE ----------------
        // Retrieve and prep the start state of the agent
        Coordinate startPoint = this.gameBoard.getStartPoint();
        Coordinate endPoint = this.gameBoard.getEndPoint();

//        System.out.println("X value of start state is " + startPoint.getX());
//        System.out.println("Y value of start state is " + startPoint.getY());
//
//        System.out.println("X value of end state is " + endPoint.getX());
//        System.out.println("Y value of end state is " + endPoint.getY());




        State start_state = new State(startPoint, State.NORTH);
        start_state.previousState = null; // Set previous node of start to null
        start_state.currentCost = 0; // current path cost of start to 0
        start_state.previousMove = null; // and the previous move to null
        Best_States[start_state.getX()][start_state.getY()][State.NORTH-1] = start_state;

//        System.out.println("Success after prepping start_state");
//

        // ------------ A* Search -------------------------
        // Adds start_point to priority queue
        OPEN.add(start_state);

        // while there are still states to be visited ...
        while(OPEN.size() != 0) {
            // Look at state with most priority
            State current = OPEN.remove();

//            System.out.println("Successfully removed state from queue");
//            System.out.println("X value of current state is " + current.getX());
//            System.out.println("Y value of current state is " + current.getY());

            // If goal is reached, return path
            if(this.gameBoard.getComplexity(current.getX(), current.getY()) == 'G') {

//                System.out.println("Successfully reached goal");
                score = 100 - current.currentCost;

                // determine series of actions in optimal path
                while(!Objects.isNull(current.previousMove)) {
                    MoveList.add(current.previousMove);
                    State temp = current.previousState;
                    current = temp;
                }
                Collections.reverse(MoveList);

                break;
            }

            // Get the next states of the current state
            List<State> NextState = agent.getNextStates(current);

            // increment the number of nodes expanded
            numNodesExpanded += NextState.size();

            // for each next_state
            for(int i = 0; i < NextState.size(); i++) {
//                // Calculate the cost of the state
//                int new_cost = current.currentCost + agent.moveCost(current, NextState.get(i));
//                // update the cost of the new state
//                NextState.get(i).currentCost = new_cost;

                // if the next state has NOT been visited yet ...
                if(Best_States[NextState.get(i).getX()]
                        [NextState.get(i).getY()]
                        [NextState.get(i).getFaceDirection()-1].getCurrentCost() == -1) {
                    // determine the priority of the new state
                    NextState.get(i).priorityValue = NextState.get(i).currentCost + myHeuristic.heuristicFunction(this.heuristic, NextState.get(i).getCoordinate(), endPoint);
//                    // set current to be the parent of the new state
//                    NextState.get(i).previousState = Best_States[current.getX()][current.getY()][current.getFaceDirection()-1];
                    // Put the next state into the cost_so_far matrix
                    Best_States[NextState.get(i).getX()][NextState.get(i).getY()][NextState.get(i).getFaceDirection()-1] = NextState.get(i);

                    // Add new state to the priority queue
                    OPEN.add(NextState.get(i));
                }
                // if new cost is smaller than the cost so far ...
                else if (Best_States[NextState.get(i).getX()]
                        [NextState.get(i).getY()]
                        [NextState.get(i).getFaceDirection()-1].getCurrentCost() > NextState.get(i).currentCost) {
                    // determine the priority of the new state
                    NextState.get(i).priorityValue = NextState.get(i).currentCost + myHeuristic.heuristicFunction(this.heuristic, NextState.get(i).getCoordinate(), endPoint);
                    // set old worse node to now be the new, better node
                    Best_States[current.getX()][current.getY()][current.getFaceDirection()-1] = NextState.get(i);
                    // Add new state to the priority queue
                    OPEN.add(NextState.get(i));
                }

            }

        } // end of the while loop



//        System.out.println("Successfully ended astar");

//        // ---------- CALCULATION OF THE OPTIMAL PATH -----------
        // Determine the number of actions in optimal path
        numActions = MoveList.size();;

        System.out.println("Score of the path: " + score);
        System.out.println("Number of actions: " + numActions);
        System.out.println("Number of nodes expanded: " + numNodesExpanded);

        for(int j = 0; j < MoveList.size(); j++) {
            System.out.println(MoveList.get(j));
        }

    } // End of A_Star_Search()
}
