package com.datastructure.graph.MazeProblem;

public class App {
    public static void main(String[] args) {
        int[][] map = {
                {1,1,1,1,1,1},
                {2,1,0,0,0,1},
                {0,1,0,1,0,1},
                {0,1,0,1,0,0},
                {0,1,0,1,1,0},
                {0,0,0,1,0,0}
        };

        MazeSolver mazeSolver = new MazeSolver(map, 1, 2);
        mazeSolver.findWay();
    }
}
