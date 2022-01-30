package com.company;

import java.io.FileNotFoundException;

/**
 * CS4341 Assignment 1
 * Professor Joseph Beck
 * Lena Dias, Roopsa Ghosh, Adam Yang
 * 1/25/2022
 */

public class AStarGame {
    // This class will be responsible for running the AStar Search Program

    // Main method to run the program
    public static void main(String[] args) throws FileNotFoundException {
        Board gameboard = new Board("assignment_1/assignment 1, sample board.txt");
        gameboard.generateBoard();
        Agent agent1 = new Agent(gameboard);
        Search search1 = new Search(gameboard, agent1, 5);
        search1.A_Star_Search();

    }

}
