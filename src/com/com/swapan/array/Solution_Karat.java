package com.com.swapan.array;/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID. 

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

For example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],    
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]


We would like to compute user sessions, specifically: write a function that takes the logs and returns a data structure that associates to each user their earliest and latest access times.

Example:
{'user_1': [54001, 58523], 
 'user_2': [54060, 62314], 
 'user_3': [53760, 53760], 
 'user_5': [53651, 53651], 
 'user_6': [2, 215], 
 'user_7': [400, 400], 
 'user_8': [100, 100],
 'user_22': [58522, 58522], 
}

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Should return:
{'user_1': [300, 1202]}

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Should return:
{'user_10': [300, 300]}

Complexity analysis variables:

n: number of logs in the input
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_Karat {
  public static void main(String[] argv) {
    String[][] logs1 = new String[][]{
            {"58523", "user_1", "resource_1"},
            {"62314", "user_2", "resource_2"},
            {"54001", "user_1", "resource_3"},
            {"200", "user_6", "resource_5"},
            {"215", "user_6", "resource_4"},
            {"54060", "user_2", "resource_3"},
            {"53760", "user_3", "resource_3"},
            {"58522", "user_22", "resource_1"},
            {"53651", "user_5", "resource_3"},
            {"2", "user_6", "resource_1"},
            {"100", "user_6", "resource_6"},
            {"400", "user_7", "resource_2"},
            {"100", "user_8", "resource_6"},
            {"54359", "user_1", "resource_3"},
    };

    String[][] logs2 = new String[][]{
            {"300", "user_1", "resource_3"},
            {"599", "user_1", "resource_3"},
            {"900", "user_1", "resource_3"},
            {"1199", "user_1", "resource_3"},
            {"1200", "user_1", "resource_3"},
            {"1201", "user_1", "resource_3"},
            {"1202", "user_1", "resource_3"}
    };

    String[][] logs3 = new String[][]{
            {"300", "user_10", "resource_5"}
    };

    String[][] logs4 = new String[][]{
            {"58523", "user_1", "resource_1"},
            {"62314", "user_1", "resource_2"},
            {"54001", "user_1", "resource_3"},
    };

    //Map<String, Queue<Integer>> result = 
    computeSession(logs1).forEach((k, v) -> {
      System.out.print(k + ":");
      if (v[0] !=v[1]) {
        System.out.print(v[0] + "," + v[1]);
      } else {
        System.out.print(v[0]);
      }

      System.out.println();
    });

  }

  private static Map<String, int[]> computeSession(String[][] logs) {

    Map<String, int[]> map = new HashMap<>();
    int[] arr;
    for (String[] log : logs) {

      arr = map.get(log[1]);
      if (arr == null) {
        arr = new int[2];
        arr[0] = Integer.MAX_VALUE;
        arr[1] = Integer.MIN_VALUE;
        map.put(log[1], arr);
      }
      int currentVal = Integer.valueOf(log[0]);
      arr[0] = Math.min(arr[0], currentVal);
      arr[1] = Math.max(arr[1], currentVal);
      map.put(log[1], arr);
    }

    return map;
  }
}
