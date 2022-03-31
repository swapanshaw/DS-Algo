package com.com.swapan.dp;

public class LongestValidParenthesis {

  static int longestValidParentheses(String s) {

    if(s == null || s.isEmpty()) return -1;

    int open = 0, close =0;
    int res = 0;

    for (int i =0;i<s.length();i++){
      if(s.charAt(i) == '(') open++;
      else close++;

      if(open == close)
        res = Math.max(res, open+close);
      else if(close>open){
        open=0;
        close=0;
      }
    }

    open=0;
    close=0;

    for (int i =s.length()-1; i>=0; i--){
      if(s.charAt(i) == '(') open++;
      else close++;

      if(open == close)
        res = Math.max(res, open+close);
      else if(open>close){
        open=0;
        close=0;
      }
    }
    return res;
    }

  public static void main(String[] args) {
    String s = "(())))(())()";
    System.out.println(longestValidParentheses(s));
  }


}
