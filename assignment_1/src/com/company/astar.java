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
//        Board gameboard = new Board("assignment_1/sampleBoard7.txt");
        Board gameboard = new Board(args[0]);
        gameboard.generateBoard();

        Agent agent1 = new Agent(gameboard);
        Search search1 = new Search(gameboard, agent1, Integer.parseInt(args[1]));
//        Search search1 = new Search(gameboard, agent1, 6);

        search1.A_Star_Search();

    }

}
