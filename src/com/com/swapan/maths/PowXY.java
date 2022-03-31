package com.com.swapan.maths;

public class PowXY {

  public double myPow(double x, int n) {
    boolean flag = false;
    int nn = 0;
    if (n < 0) {
      flag = true;
      nn = Math.abs(n);
    }

    double ans = 1;
    while (nn >= 0) {
      if (nn % 2 == 0) {
        x = x * x;
        nn = nn / 2;
      } else {
        ans = ans * x;
        nn--;
      }
    }
    return flag ? 1 / ans : ans;
  }
}
