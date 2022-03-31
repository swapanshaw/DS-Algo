package com.com.swapan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<char[], List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = new char[26];

      for (char c : str.toCharArray()) {
        chars[c - 'a']++;
      }

      map.putIfAbsent(chars, new ArrayList<>());
      map.get(chars).add(str);
    }
    return new ArrayList<>(map.values());
  }
}
