package com.company;
import java.util.*;

public class AStar {


    public AStar() {

    }


    PriorityQueue<Coordinate> CoordinateComparator = new PriorityQueue<Coordinate>(new Comparator<Coordinate>()
    {

        @Override
        public int compare(Coordinate c1, Coordinate c2) {
            return c1.getPriority() - c2.getPriority();
        }
    });

    public Coordinate search(Coordinate start_point) {
        // Priority queue for Coordinates to visit
        PriorityQueue<Coordinate> OPEN = new PriorityQueue<Coordinate>(CoordinateComparator);

        // Adds start_point to priority queue
        OPEN.add(start_point);

        // initialize arrays to hold previous nodes and current path cost to coordinates
        Coordinate[][] came_from = new Coordinate[][];
        int[][] cost_so_far = new int[][];

        // set previous node of start to null, and current path cost of start to 0
        came_from[start_point.getX()][start_point.getY()] = null;
        cost_so_far[start_point.getX()][start_point.getY()] = 0;

        while(OPEN.size() != 0) {
            // get coordinate with most priority
            Coordinate current = OPEN.remove();

            // if goal is reached, return path
            if(current.getComplexity() == 'G') {
                return current;
            }
//
//          Neighbors = board.getNeighbors(current);
            for next in graph.neighbors(current):
            new_cost = cost_so_far[current] + graph.cost(current, next)
            if next not in cost_so_far or new_cost < cost_so_far[next]:
            cost_so_far[next] = new_cost
            priority = new_cost + heuristic(goal, next)
            frontier.put(next, priority)
            came_from[next] = current
        }


        return 1;
    }


    public static void main(String[] args) {
        AStar astar1 = new AStar();
        astar1.search();

    }



}
