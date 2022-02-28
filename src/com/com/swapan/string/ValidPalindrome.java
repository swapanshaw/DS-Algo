package com.com.swapan.string;

import java.util.Locale;

public class ValidPalindrome {
  public static void main(String[] args) {
    System.out.println(isValidPalindrame(".."));
  }


  static boolean isValidPalindrame(String s) {
    int len = s.length();
    int i =0;
    int j = len-1;
    while(i <= j) {
      while (i < len && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }
      if(i>=len || j < 0) return true;
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        System.out.println(i + " " + j);
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
