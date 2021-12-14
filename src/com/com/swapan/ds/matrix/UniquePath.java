package com.com.swapan.ds.matrix;

public class UniquePath {

  static int countPathRec(int m, int n) {

    if (m == 1 || n == 1) {
      return 1;
    }

    return countPathRec(m - 1, n) + countPathRec(m, n - 1);
    // if diagonal is allowed then  countPathRec(m-1, n-1)
  }

  static int countPathDP(int m, int n) {
    int dp[][] = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
          continue;
        }

        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(countPathRec(2, 3));

    System.out.println(countPathDP(3, 3));
  }
}
