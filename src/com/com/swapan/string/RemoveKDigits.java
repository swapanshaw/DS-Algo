package com.com.swapan.string;

import java.util.Stack;

public class RemoveKDigits {

  static String removeKDigit(String str, int k) {
    int n = str.length();
    StringBuilder stringBuilder = new StringBuilder();
    if (n == 0) return "0";

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      Character c = str.charAt(i);

      while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
        k--;
        stack.pop();
      }

      stack.push(c);
    }

    while (!stack.isEmpty() && k > 0) {
      stack.pop();
      k--;
    }

    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }

    return stringBuilder.reverse().toString();
  }


  public static void main(String[] args)
  {
    String s = "121198";
    int k = 5;
    System.out.println(removeKDigit(s, 3));
  }
}
