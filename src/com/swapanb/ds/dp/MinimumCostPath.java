package com.swapanb.ds.dp;

public class MinimumCostPath {
  public static void main(String[] args) {
    int [][]grid = {
            {1,3,5},
            {2,1,2},
            {4,3,1}
    };

    System.out.println(minPathSum(grid));
  }

  static int minPathSum(int grid[][]) {
    int r = grid.length;
    int c = grid[0].length;

    int t[][] = new int[r + 1][c + 1];
    for (int i = 0; i <= r; i++) {
      for (int j = 0; j <= c; j++) {
        if (i ==0|| j==0) {
          t[i][j] = 0;
          continue;
        }

        t[i][j] = grid[i-1][j-1] + Math.min(t[i-1][j], t[i][j-1]);
      }
    }
    return t[r][c];
  }
}
