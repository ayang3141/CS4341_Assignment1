package com.company;

import java.io.*;
import java.util.*;
import java.lang.*;


// This class is responsible for holding information regarding the board that the
// agent will traverse
public class Board {

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

    // This method finds the end point of the board,
    // end point is coordinate with 'G'
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

    // Returns the terrain complexity of a certain coordinate
    public char getComplexity(int x_Coord, int y_Coord) {
        return gameboard[x_Coord][y_Coord];
    }

    // This method determines if the given coordinate is out of bounds
    public boolean OutOfBounds(Coordinate coordinate) {
        if((coordinate.getX() >= 0) && (coordinate.getX() <= numRows-1)
                && (coordinate.getY() >= 0) && (coordinate.getY() <= numCols-1)) {
            return false;
        }
        return true;
    }

    // This method generates the game board from the given file name
    public void generateBoard() throws FileNotFoundException {
        //File I/O
        try {

            File levelFile = new File(this.fileName);

            //count total chars
            BufferedReader colScanner = new BufferedReader(new FileReader(levelFile));
            String line = null;
            while((line = colScanner.readLine()) != null)
            {
                System.out.println(line);
                //tokenize it here
                String[] tokens = line.split("\t");
                numCols = tokens.length;
                numRows++;
            }

            System.out.println(numCols);
            System.out.println(numRows);

            Scanner sc = new Scanner(levelFile);
            sc.useDelimiter("\\n|\\t");
            char[][] level = new char[numRows][numCols];



            //now, actually put them in a list. would be better to do this all in one loop, but this works.
            for (int i = 0; i < numRows; i++)
            {
                for (int j = 0; j < numCols; j++)
                {
                    if(sc.hasNext())
                    {
                        char ch = sc.next().charAt(0); // Convert to char
                        level[i][j] = ch;
                        //System.out.println(ch);
                        //System.out.println(level[i][j]);
                    }
                }
            }
            this.gameboard = level;
            sc.close();
        }
        catch (FileNotFoundException err)
        {
            System.out.println("File not found.");
            err.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Board myBoard = new Board("assignment_1/assignment 1, sample board - 0.txt");
        myBoard.generateBoard();
    }



}
