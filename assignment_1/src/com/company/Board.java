package com.company;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Board {
    // This class is responsible for holding information regarding the board that the
    // agent will traverse

    int numRows;
    int numCols;
    char[][] gameboard = new char[numRows][numCols];
    String fileName;

    // Constructor for the Board class
    public Board(String fileName) {
        this.fileName = fileName;
    }

    // This method finds the starting point of the board,
    // Starting point is coordinate with 'S'
    public Coordinate getStartPoint() {
        // return the coordinate of the "S" tile
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(gameboard[i][j] == 'S') {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }

    public Coordinate getEndPoint() {
        // return the coordinate of the "S" tile
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(gameboard[i][j] == 'G') {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }

    public char getComplexity(int x_Coord, int y_Coord) {
        return gameboard[x_Coord][y_Coord];
    }

    // This method determines if the given coordinate is out of bounds
    public boolean OutOfBounds(Coordinate coordinate) {
        if((coordinate.getX() >= 0) && (coordinate.getX() <= numRows-1)
                && (coordinate.getY() >= 0) && (coordinate.getY() <= numCols-1)) {
            return true;
        }
        return false;
    }


    // This method generates the game board from the file name attribute
    public void generateBoard() throws FileNotFoundException {
        final int ROW = 3;
        final int COL = 4;
        char[][] level = new char[ROW][COL];

        //File I/O
        try {
            //Establish scanners
            File levelFile = new File(this.fileName);
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

    public static void main(String[] args) throws FileNotFoundException {
        Board myBoard = new Board("assignment_1/assignment 1, sample board.txt");
        myBoard.generateBoard();
    }



}
