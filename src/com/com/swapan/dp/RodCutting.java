package com.com.swapan.dp;

public class RodCutting {

  public static void main(String[] args) {
    int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
    int size = arr.length;
    System.out.println("Maximum Obtainable Value is " +
            cutRod(arr, size, size));

    System.out.println("Maximum Obtainable Value is[DP] " +
            cutRodDP(arr));
  }

  static int cutRod(int arr[], int n, int maxLen) {
    if (n == 0) return 0;

    if (maxLen == 0) return 1;

    if (n - 1 <= maxLen) {
      return Math.max(arr[n - 1] + cutRod(arr, n, maxLen - n - 1), cutRod(arr, n - 1, maxLen));

    } else {
      return cutRod(arr, n - 1, maxLen);
    }
  }


  static int cutRodDP(int arr[]) {
    int n = arr.length;
    int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int[][] t = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
          continue;
        }

        if (length[i - 1] <= j) {
          t[i][j] = Math.max((arr[i - 1] + t[i][j - length[i - 1]]), t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][n];
  }
}
