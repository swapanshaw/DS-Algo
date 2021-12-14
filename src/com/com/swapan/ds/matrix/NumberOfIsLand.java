package com.com.swapan.ds.matrix;

public class NumberOfIsLand {

  public static void main(String[] args) {
    int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 1, 0, 0, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 1, 0, 1, 0, 1 } };
    System.out.println("Number of islands is: " + countIsLand(M));
  }

  static int countIsLand(int[][] m) {
    if (m.length == 0) {
      return 0;
    }

    int row = m.length;
    int col = m[0].length;

    boolean visited[][] = new boolean[row][col];
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (isSafe(m, i, j, row, col, visited)) {
          dfs(m, i, j, row, col, visited);
          count++;
        }
      }
    }

    return count;
  }

  private static void dfs(int[][] m, int i, int j, int row, int col, boolean[][] visited) {
    if (!isSafe(m, i, j, row, col, visited)) {
      return;
    }

    visited[i][j] = true;

    // recurse in all 8 direction
    dfs(m, i - 1, j - 1, row, col, visited);
    dfs(m, i + 1, j + 1, row, col, visited);
    dfs(m, i - 1, j, row, col, visited);
    dfs(m, i, j - 1, row, col, visited);
    dfs(m, i + 1, j, row, col, visited);
    dfs(m, i, j + 1, row, col, visited);
    dfs(m, i + 1, j - 1, row, col, visited);
    dfs(m, i - 1, j + 1, row, col, visited);
  }

  private static boolean isSafe(int[][] m, int i, int j, int row, int col, boolean[][] visited) {

    return (i >= 0 && i < row && j >= 0 && j < col && (m[i][j] == 1 && !visited[i][j]));
  }
}
