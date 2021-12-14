package com.com.swapan.ds.matrix;

public class RatInAMaze {


  public static void main(String args[]) {
    int maze[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}};

    solveMaze(maze);
  }

  private static void solveMaze(int[][] maze) {

    int N = maze.length;

    int sol[][] = new int[N][N];

    boolean isPossible = solvemazeUti(maze, N, 0, 0, sol);
    System.out.println(isPossible);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(
                " " + sol[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(sol);
  }

  private static boolean solvemazeUti(int[][] maze, int n, int i, int j, int[][] sol) {

    // Base condition, when it reached at the end,
    if (i == n - 1 && j == n - 1 && maze[i][j] == 1) {
      sol[i][j] = 1;
      return true;
    }

    // do in the different direction, (i+1,j), (i-1,j), (i, j-1), (i, j+1)

    if (isSafe(maze, n, i, j, sol)) {
      sol[i][j] = 1;
      if (solvemazeUti(maze, n, i - 1, j, sol))
        return true;
      if (solvemazeUti(maze, n, i + 1, j, sol))
        return true;
      if (solvemazeUti(maze, n, i, j - 1, sol))
        return true;
      if (solvemazeUti(maze, n, i, j + 1, sol))
        return true;

      // if non of the above works then backtrack
      sol[i][j] = 0;
      return false;
    }

    return false;
  }

  private static boolean isSafe(int[][] maze, int n, int i, int j, int[][] sol) {

    return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && sol[i][j] == 0);
  }

}
