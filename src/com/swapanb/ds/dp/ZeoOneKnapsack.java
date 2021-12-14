package com.swapanb.ds.dp;

public class ZeoOneKnapsack {

  static int knapSack(int wt[], int val[], int w, int n) {
    if (n == 0 || w == 0)
      return 0;

    if (wt[n - 1] <= w) {
      return Math.max((val[n - 1] + knapSack(wt, val, w - wt[n - 1], n - 1)),
              knapSack(wt, val, w, n - 1)
      );
    }

    return knapSack(wt, val, w, n - 1);

  }

  static int knapSackDP(int wt[], int val[], int w) {
    int n = wt.length;

    int[][] t = new int[n][w];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < w; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
          continue;
        } else if (wt[i] <= j) {
          t[i][j] = Math.max((val[i] + t[i - 1][w - wt[i - 1]]), t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }

    return t[n - 1][w - 1];
  }

  public static void main(String[] args) {
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(wt, val, W, n));

    System.out.println(knapSackDP(wt, val, W));
  }
}
