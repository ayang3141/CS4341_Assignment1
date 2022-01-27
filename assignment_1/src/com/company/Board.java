package com.company;
/**
 * CS4341 Assignment 1
 * Professor Joseph Beck
 * Lena Dias, Roopsa Ghosh, Adam Yang
 * 1/25/2022
 */

import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class Board {
    // This class is responsible for holding information regarding the board that the
    // agent will traverse

    int numRows;
    int numCols;
    char[][] gameboard = new char[numRows][numCols];
    String fileName;

    public Board(String fileName) {
        this.fileName = fileName;
    }


    public Coordinate getStartPoint() {
        // return the coordinate of the "S" tile
        return null;
    }


    public boolean OutOfBounds(Coordinate coordinate) {
//        if(coordinate is out of bounds) {
//            return true;
//        }
        return false;
    }



    public void generateBoard(String[] args) throws IOException {
        final int ROW = 3;
        final int COL = 4;
        char[][] level = new char[ROW][COL];

        //File I/O
        try {
            //Establish scanners
            File levelFile = new File("assignment_1/assignment 1, sample board.txt");
            Scanner sc = new Scanner(levelFile);
            sc.useDelimiter("(\\r\\n)|\\t");

            //Scan file TODO refactor to auto-configure row/col?
            for (int i = 0; i < ROW; i++)
            {
                for (int j = 0; j < COL; j++)
                {
                    if(sc.hasNext())
                    {
                        char ch = sc.next().charAt(0); // Convert to char
                        level[i][j] = ch;
                        System.out.println(level[i][j]);
                    }
                }
            }
            sc.close();

        }
        catch (FileNotFoundException err)
        {
            System.out.println("File not found.");
            err.printStackTrace();
        }
    }





}
