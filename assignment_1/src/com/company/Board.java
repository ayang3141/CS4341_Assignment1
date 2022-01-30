package com.company;

import java.io.*;
<<<<<<< Updated upstream
import java.util.Scanner;
=======
import java.nio.Buffer;
import java.util.*;
>>>>>>> Stashed changes
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
        numRows = 0;
        numCols = 0;
        this.fileName = fileName;
    }

    // This method finds the starting point of the board,
    // Starting point is coordinate with 'S'
    public Coordinate getStartPoint() {
        // return the coordinate of the "S" tile
        return null;
    }

    // This method determines if the given coordinate is out of bounds
    public boolean OutOfBounds(Coordinate coordinate) {
//        if(coordinate is out of bounds) {
//            return true;
//        }
        return false;
    }

<<<<<<< Updated upstream

    // This method generates the game board from the file name attribute
    public void generateBoard() throws IOException {
        final int ROW = 3;
        final int COL = 4;
        char[][] level = new char[ROW][COL];

        //File I/O
        try {
            //Establish scanners
            File levelFile = new File("assignment_1/assignment 1, sample board.txt");
=======
    // This method generates the game board from the given file name
    public void generateBoard() throws FileNotFoundException {
        //File I/O
        try {
            //TODO: clean up these comments Lena they are nasty - 5 AM Lena

            File levelFile = new File(this.fileName);

            //count total chars
            BufferedReader colScanner = new BufferedReader(new FileReader(levelFile));
            String line = null;
            while((line = colScanner.readLine()) != null)
            {
                System.out.println(line);
                //tokenize it here
                String[] tokens = line.split("\\t");
                numCols = tokens.length;
                numRows++;
            }

            System.out.println(numCols);
            System.out.println(numRows);

>>>>>>> Stashed changes
            Scanner sc = new Scanner(levelFile);
            sc.useDelimiter("(\\r\\n)|\\t");
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





}
