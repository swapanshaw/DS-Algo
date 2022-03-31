package com.com.swapan.ds.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  static List<Integer> spiralOrder(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;

    int top = 0, left = 0;
    int down = row - 1, right = col - 1;

    List<Integer> result = new ArrayList<>();

    while (result.size() <= row * col) {
      // fill the left to right, up
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }

      // fill top to bottom

      for (int i = top + 1; i <= down; i++) {
        result.add(matrix[i][right]);
      }

      // right to left
      for (int i = right - 1; i >= left; i--) {
        result.add(matrix[down][i]);
      }

      // buttom  to up
      for (int i = down - 1; i >= top; i--) {
        result.add(matrix[i][left]);
      }
      left++;
      top++;
      down--;
      right--;
    }

    return result;
  }

  public static void main(String[] args) {
    int[][] m = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    List<Integer> res = spiralOrder(m);

    res.forEach(System.out::println);


  }


}
