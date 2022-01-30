package com.company;

/**
 * CS4341 Assignment 1
 * Professor Joseph Beck
 * Lena Dias, Roopsa Ghosh, Adam Yang
 * 1/25/2022
 */

public class AStarGame {
    // This class will be responsible for running the AStar Search Program

    // Main method to run the program
<<<<<<< Updated upstream:assignment_1/src/com/company/AStarGame.java
    public static void main(String[] args) {
        Board gameboard = new Board("assignment_1/assignment 1, sample board.txt");
=======
    public static void main(String[] args) throws FileNotFoundException {
        //TODO: take command line arguments
        //TODO: have a proper ending to the program (process exited with -1)

        Board gameboard = new Board("assignment_1/assignment 1, sample board - 0.txt");
>>>>>>> Stashed changes:assignment_1/src/com/company/astar.java
        gameboard.generateBoard();
        Agent agent1 = new Agent(gameboard);
        Search search1 = new Search(gameboard, agent1);
        search1.A_Star_Search();

    }

}
