package com.swapanb.ds.dp;

public class DynamicPrograming {
  public static void main(String[] args) {
    /*int M[][] = {{0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}};

    printMaxSubSquare(M);*/

    //LCS("GeeksforGeeks", "GeeksQuiz");
    longestCommonSubsequence("stone", "longest");

    longestIncreasingSubsequence(new int[]{8, 100, 150, 10, 12, 14, 110});
  }

  static int longestBitonicSequence(int[] arr) {
    int len = arrLen(arr);

    int lis[] = new int[len];
    int lds[] = new int[len];
    for (int i = 0; i < len; i++) {
      lds[i] = 1;
      lis[i] = 1;
    }
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          lis[i] = Math.max(lis[i], 1 + lis[j]);
        }
      }
    }


    for (int i = len - 2; i > 0; i++) {
      for (int j = len - 1; j > i; j++) {
        if (arr[j] < arr[i]) {
          lis[i] = Math.max(lds[i], 1 + lds[j]);
        }
      }
    }

    int max = lis[0] + lis[1] - 1;

    for (int i = 1; i < len; i++) {
      max = Math.max(max, lis[i] + lds[i] - 1);
    }

    return max;
  }

  private static int arrLen(int[] arr) {
    return arr.length;
  }

  static int longestIncreasingSubsequence(int[] arr) {
    int len = arr.length;
    int[] lis = new int[len];
    lis[0] = 1;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          lis[i] = Math.max(lis[i], 1 + lis[j]);
        }
      }
    }
    int res = 0;
    for (int i = 0; i < len; i++) {
      res = Math.max(lis[i], res);
    }
    System.out.println("LIS : " + res);
    return res;
  }

  static int longestCommonSubsequence(String str1, String str2) {
    int m = str1.length(), n = str2.length();
    if (m == 0 || n == 0) {
      return 0;
    }

    int dp[][] = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
          continue;
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    System.out.println(String.valueOf(dp[m][n]));
    return dp[m][n];
  }

  static int LCS(String str1, String str2) {
    if (str1.length() == 0 || str2.length() == 0) {
      return -1;
    }
    int row = str1.length() + 1;
    int col = str2.length() + 1;

    int dp[][] = new int[row + 1][col + 1];
    int result = 0;
    int maxI = 0;
    int maxJ = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
          continue;
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          if (result < dp[i][j]) {
            result = dp[i][j];
            maxI = i;
            maxJ = j;
          }
        } else {
          dp[i][j] = 0;
        }
      }
    }
    System.out.printf(String.valueOf(result));
    System.out.printf(String.valueOf(maxI) + "," + String.valueOf(maxJ));
    return result;
  }

  static void printMaxSubSquare(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int dp[][] = new int[row][col];

    //populate 1st row
    for (int i = 0; i < row; i++) {
      dp[i][0] = matrix[i][0];
    }

    for (int i = 0; i < col; i++) {
      dp[0][i] = matrix[0][i];
    }

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (matrix[i][j] == 1) {
          dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
        } else {
          dp[i][j] = 0;
        }
      }
    }

    // find the max, max_i, max_j
    int max = 0, max_i = 0, max_j = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (max < dp[i][j]) {
          max = dp[i][j];
          max_i = i;
          max_j = j;
        }
      }
    }

    //print the max square matrix
    for (int i = max_i; i > max_i - max; i--) {
      for (int j = max_j; j > max_j - max; j--) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
