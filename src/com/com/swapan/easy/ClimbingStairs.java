package com.com.swapan.easy;

public class ClimbingStairs {

  /**
   * You are climbing a staircase. It takes n steps to reach the top.
   * <p>
   * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
   *
   * @param n
   * @return
   */
  static int climbStairs(int n) {
    return climbStairs(0, n);
  }

  static private int climbStairs(int i, int n) {
    if (i == 0) return 0;

    if (i == n) return 1;

    return climbStairs(i + 1, n) + climbStairs(i + 2, n);
  }

  static private int climbStairsMemoisation(int i, int n, int[] memo) {
    if (i == 0) return 0;

    if (i == n) return 1;

    if (memo[i] != 0) return memo[i];
    memo[i] = climbStairs(i + 1, n) + climbStairs(i + 2, n);

    return memo[i];
  }

  static private int climbStairsDP(int i, int n) {

    int []dp = new int[n+1];
    if (i == 0) return 0;

    if (i == n) return 1;

    return climbStairs(i + 1, n) + climbStairs(i + 2, n);
  }


}
