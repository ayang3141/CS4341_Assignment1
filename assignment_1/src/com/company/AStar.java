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

    public int search() {
        // Priority queue for Coordinates to visit
        PriorityQueue<Coordinate> OPEN = new PriorityQueue<Coordinate>(CoordinateComparator);

        OPEN.add(new Coordinate(200, 2, 'c', 5));
        OPEN.add(new Coordinate(40, 4, 'b', 2));
        OPEN.add(new Coordinate(3, 3, 'a', 10));

//        // Remove items from the Priority Queue (DEQUEUE)
        while (!OPEN.isEmpty()) {
            Coordinate e = OPEN.remove();
            System.out.print(e.getX());
            System.out.print(' ');
            System.out.print(e.getY());
            System.out.print(' ');
            System.out.print(e.getComplexity());
            System.out.print(' ');
            System.out.println(e.getPriority());
        }



//        OPEN.insert(gameboard.start, 0);
//        came_from = dict()
//        cost_so_far = dict()
//        came_from[start] = None
//        cost_so_far[start] = 0
//
//        while(OPEN.size() != 0):
//            Coordinate current = OPEN.remove();
////
//            if(current.getComplexity() == 'G') {
//                return 1;
//            }
////
////          Neighbors = board.getNeighbors(current);
//            for next in graph.neighbors(current):
//                new_cost = cost_so_far[current] + graph.cost(current, next)
//                if next not in cost_so_far or new_cost < cost_so_far[next]:
//                    cost_so_far[next] = new_cost
//                    priority = new_cost + heuristic(goal, next)
//                    frontier.put(next, priority)
//                    came_from[next] = current
//
        return 1;
    }


    public static void main(String[] args) {
        AStar astar1 = new AStar();
        astar1.search();

    }



}
