package com.swapan.array;

import java.util.HashSet;
import java.util.Set;

class Solution {
  static boolean isValidSudoku(char[][] board) {

    int row = board.length;
    int col = board[0].length;
    Set<Character> set = null;
    // check row wise repeating numbers
    boolean isValid = true;
    for (int i = 0; i < row; i++) {
      set = new HashSet<>();
      for (int j = 0; j < col; j++) {
        char value = board[i][j];
        if (value != '.') {
          if (set.contains(value)) {
            System.out.println("row");
            isValid = false;
            break;
          } else {
            set.add(board[i][j]);
          }
        }
      }
    }

    if (!isValid) {
      return false;
    }

    // check column wise repeating numbers

    for (int i = 0; i < col; i++) {
      set = new HashSet<>();
      for (int j = 0; j < row; j++) {
        char value = board[i][j];
        if (value != '.') {
          if (set.contains(value)) {
            System.out.println("col");
            isValid = false;
            break;
          } else {
            set.add(board[i][j]);
          }
        }
      }
    }

    if (!isValid) {
      return false;
    }
    // check each square wise repeating numbers

    for (int i = 0; i < row - 2; i += 3) {
      for (int j = 0; j < col - 2; j += 3) {
        set = new HashSet<>();
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 3; l++) {
            char value = board[i + k][j + l];
            if (value != '.') {
              if (set.contains(value)) {
                System.out.println("col");
                isValid = false;
                break;
              } else {
                set.add(board[i + k][j + l]);
              }
            }

            if (!isValid) {
              break;
            }
          }
        }

      }
    }
    return isValid;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    System.out.println(isValidSudoku(board));
  }
}