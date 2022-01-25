/**
 * CS4341 Assignment 1
 * Professor Joseph Beck
 * Lena Dias, Roopsa Ghosh, Adam Yang
 * 1/25/2022
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;


public class Assignment_1 {
    public static void main(String[] args) throws IOException {
        final int ROW = 3;
        final int COL = 4;
        char[][] level = new char[ROW][COL];

        //File I/O
        try {
            //Establish scanners
            File levelFile = new File("assignment 1, sample board.txt");
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
                        }
                    }
            }
            sc.close();
            //System.out.println(Arrays.deepToString(level));
        }
        catch (FileNotFoundException err)
        {
            System.out.println("File not found.");
            err.printStackTrace();
        }
    }

}