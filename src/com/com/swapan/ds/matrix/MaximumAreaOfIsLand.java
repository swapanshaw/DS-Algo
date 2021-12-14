package com.com.swapan.ds.matrix;

public class MaximumAreaOfIsLand {
  static boolean[][] visited;

  static int maxAreaOfIsLand(int[][] grid) {
    int row = grid.length;
    if (row == 0) return 0;
    int col = grid[0].length;
    visited = new boolean[row][col];
    int max = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        max = Math.max(max, area(i, j, row, col, grid));

      }
    }
    return max;
  }

  static int area(int i, int j, int r, int c, int[][] grid) {
    if (i < 0 || i >= r || i < 0 || j >= c || grid[i][j] == 0 || visited[i][j])
      return 0;

    visited[i][j] = true;

    return 1 + area(i - 1, j, r, c, grid)
            + area(i + 1, j, r, c, grid)
            + area(i, j - 1, r, c, grid)
            + area(i, j + 1, r, c, grid);
  }


  public static void main(String[] args) {
    int[][] grid  = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
    };

    System.out.println("max area " + maxAreaOfIsLand(grid));
  }
}
