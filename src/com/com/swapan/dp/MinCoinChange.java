package com.com.swapan.dp;

public class MinCoinChange {

  static int coinChange(int[] coins, int amount) {
    // If amount == 0, then 0 coins required.
    if (amount == 0) return 0;

    int res = Integer.MAX_VALUE;

    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) {
        int subRes = coinChange(coins, amount - coins[i]);
        if (subRes != Integer.MAX_VALUE) {
          res = Math.min(res, subRes + 1);
        }
      }
    }
    return res;
  }

  static int coinChangeDP(int[] coins, int amount) {

    // table[i] will be storing
    // the minimum number of coins
    // required for i value. So
    // table[V] will have result
    int[] table = new int[amount + 1];

    // Base case (If given value V is 0)
    table[0] = 0;

    for (int i = 1; i <= amount; i++) {
      table[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (coins[i] <= j) {
          int subRes = table[j - coins[i]];
          if (subRes != Integer.MAX_VALUE) {
            table[j] = Math.min(table[j], 1 + subRes);
          }
        }
      }
    }

    return table[amount];
  }

  public static void main(String[] args) {
    int coinChange = coinChangeDP(new int[]{1, 2, 5}, 11);
    System.out.println(coinChange);
  }
}
