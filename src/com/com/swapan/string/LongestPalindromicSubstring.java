package com.com.swapan.string;

public class LongestPalindromicSubstring {
  int maxLen = 0;
  int start = 0;
  int end = 0;

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    int len = s.length();
    for (int i = 0; i < len; i++) {
      expand(s, i, i);
      expand(s, i, i + 1);
    }

    return s.substring(start, start + maxLen);
  }

  private void expand(String str, int l, int r) {

    while ((l >= 0 && r < str.length()) && (str.charAt(l) == str.charAt(r))) {
      l--;
      r++;
    }

    if (r - l - 1 > maxLen) {
      maxLen = r - l - 1;
      start = l + 1;
    }
  }

  int longestSubstringWithoutDuplicate(String str) {
    int len = str.length();
    int res = 1;
    String s = "";
    for (int i = 0; i < len; i++) {
      Character c = str.charAt(i);
      String checkChar = c.toString();

      if (s.contains(checkChar)) {
        s = s.substring(s.indexOf(c) + 1);

      }
      s += checkChar;
      res = Math.max(s.length(), res);
    }

    System.out.println(s);
    return res;
  }


  public static void main(String[] args) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    System.out.println(longestPalindromicSubstring.longestPalindrome("aba"));

    String s = "abcabcbb";
    System.out.println(longestPalindromicSubstring.longestSubstringWithoutDuplicate(s));
  }
}
