package com.swapan.array;

public class JumpGame2 {
  static int jump(int[] nums) {
    int farthestJump = 0;
    int currJump = 0;
    int jump = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      farthestJump = Math.max(farthestJump, i + nums[i]);
      if (i == currJump) {
        jump++;
        currJump = farthestJump;
      }
    }
    return jump;
  }

  public static void main(String[] args) {
    System.out.println(jump(new int[]{2,3,1,1,4}));
  }
}
