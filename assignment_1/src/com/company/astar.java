package com.company;

import java.io.FileNotFoundException;

/**
 * CS4341 Assignment 1
 * Professor Joseph Beck
 * Lena Dias, Roopsa Ghosh, Adam Yang
 * 1/25/2022
 */

// This class will be responsible for running the AStar Search Program
public class astar {

    // Main method to run the program
    public static void main(String[] args) throws FileNotFoundException {
        Board gameboard = new Board("assignment_1/assignment 1, sample board - 0.txt");

        gameboard.generateBoard();
        System.out.println("this board has " + gameboard.numRows + " rows");
        System.out.println("this board has " + gameboard.numCols + " columns");

        Coordinate start = gameboard.getStartPoint();
        System.out.println(start.getX());
        System.out.println(start.getY());

        Agent agent1 = new Agent(gameboard);
        Search search1 = new Search(gameboard, agent1, 5);
        search1.A_Star_Search();

    }

}
