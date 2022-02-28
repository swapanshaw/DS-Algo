package com.com.swapan.subset;


import java.util.ArrayList;
import java.util.List;

public class SubSet {

  static List<List<Integer>> getSubset(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());

    for (int num : nums) {
      int n = ans.size();
      for (int i = 0; i < n; i++) {
        List<Integer> temp = new ArrayList<>(ans.get(i));
        temp.add(num);
        ans.add(temp);
      }
    }
    return ans;
  }
  // TC - O(n*2^n)
  static void generateSubSet(int idx, int[] nums, List<Integer> local, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(local));
    for (int i = idx; i < nums.length; i++) {
      local.add(nums[i]);
      generateSubSet(i + 1, nums, local, ans);
      local.remove(local.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(getSubset(nums));

    List<List<Integer>> ans = new ArrayList<>();
    generateSubSet(0, nums, new ArrayList<>(), ans);

    System.out.println(ans);
  }
}
