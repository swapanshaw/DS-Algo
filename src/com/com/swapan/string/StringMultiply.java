package com.com.swapan.string;

public class StringMultiply {


  static String multiply(String num1, String num2) {

    if (num1 == "0" || num2 == "0") return "0";

    int n = num1.length(), m = num2.length();
    int res[] = new int[n + m];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        int curr = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        res[i + j + 1] += curr % 10;
        res[i + j] = curr / 10;
      }
    }

    int i = 0;
    String ans = "";
    while (res[i] == 0) i++;

    while (i < res.length) {
      ans += res[i++];
    }

    return ans;
  }


  public static void main(String[] args) {
    System.out.println(multiply("13", "12"));
  }
}
