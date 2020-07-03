package com.dovis.fseasunny.algorithm.recursive;

import static com.dovis.fseasunny.algorithm.util.ArrayUtils.displayArray;

/**
 * classname: BallFindingTheWay
 * description:
 * date: 2020/7/3 15:25
 * author: xue
 * version: 1.0
 */
public class BallFindingTheWay {

    public static final int NOT_YET = 0;
    public static final int OBSTACLE = 1;
    public static final int ALREADY = 2;
    public static final int BLOCKED_UP = 3;

    public static void main(String[] args) {

        int[][] maze = buildMaze(8, 7);
        addObstacle(maze, 3, 1);
        addObstacle(maze, 3, 2);
        addObstacle(maze, 2, 2);
//        addObstacle(maze, 1, 2);
        System.out.println(displayArray(maze));
        System.out.println(findWay(maze, 2, 1));
        System.out.println(displayArray(maze));
    }


    public static boolean findWay(int[][] maze, int x, int y) {
        if (maze[maze.length - 2][maze[0].length - 2] == ALREADY) {
            return true;
        }
        if (maze[x][y] == NOT_YET) {
            maze[x][y] = ALREADY;
            if (findWay(maze, x + 1, y)) {
                return true;
            } else if (findWay(maze, x, y + 1)) {
                return true;
            } else if (findWay(maze, x - 1, y)) {
                return true;
            } else if (findWay(maze, x, y - 1)) {
                return true;
            } else {
                maze[x][y] = BLOCKED_UP;
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * 构建迷宫
     */
    public static int[][] buildMaze(int row, int column) {
        int[][] maze = new int[row][column];
        for (int i = 0; i < column; i++) {
            maze[0][i] = 1;
            maze[row - 1][i] = OBSTACLE;
        }
        for (int i = 0; i < row; i++) {
            maze[i][0] = 1;
            maze[i][column - 1] = OBSTACLE;
        }
        return maze;
    }

    /**
     * 添加障碍物
     */
    public static void addObstacle(int[][] maze, int xIndex, int yIndex) {
        maze[xIndex][yIndex] = OBSTACLE;
    }

}
