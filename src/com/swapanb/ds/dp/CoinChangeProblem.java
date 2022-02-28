package com.swapanb.ds.dp;

public class CoinChangeProblem {
  /**
   * Unbounded knapsack problem
   * as we can choose same coin gain.
   */
  static int noOfWaysToChangeCoins(int arr[], int n, int sum) {
    //Found one set
    if (sum == 0) {
      return 1;
    }
    //Exhausted all the arrangements
    if (n == 0) {
      return 0;
    }
    if (arr[n - 1] <= sum) {
      return noOfWaysToChangeCoins(arr, n, sum - arr[n - 1]) + noOfWaysToChangeCoins(arr, n - 1, sum);
    } else {
      //exclude the coin
      return noOfWaysToChangeCoins(arr, n - 1, sum);
    }
  }

  static int noOfWaysToChangeCoinsDP(int arr[], int n, int sum) {
    int t[][] = new int[n + 1][sum + 1];
    // when we need to make zero sum with any coins, we can do it in  1 ways
    for (int i = 0; i <= n; i++) {
      t[i][0] = 1;
    }

    for (int i = 1; i <= sum; i++) {
      t[0][i] = 0;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {

        if (arr[i - 1] <= j) {
          // we have two choice either include or exclude, here we are calculating numbers of ways, so sum it up
          t[i][j] = t[i - 1][j] + t[i][j - arr[i - 1]];
        } else {
          t[i][j] = t[i - 1][j]; // only exclusion
        }
      }
    }
    return t[n][sum];
  }


  static int coinChangeMinDP(int arr[], int n, int sum) {
    int t[][] = new int[n][sum + 1];
    // when we need to make zero sum with any coins, we can do it in  1 ways
    for (int i = 0; i < n; i++) {
      t[i][0] = 0;
    }

    for (int i = 0; i <=sum; i++) {
      t[0][i] = i;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= sum; j++) {

        if (arr[i] > j) {
          t[i][j] = t[i - 1][j]; // only exclusion
          // we have two choice either include or exclude, here wer are calculating minimum coins
        } else {
          t[i][j] = Math.min(t[i - 1][j], (1 + t[i][j - arr[i]]));
        }
      }
    }
    return t[n-1][sum];
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 5};

    System.out.println(noOfWaysToChangeCoinsDP(arr, arr.length, 11));

    System.out.println(coinChangeMinDP(arr, arr.length, 5));
  }
}
