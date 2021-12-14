package com.swapan.array;

import java.util.HashSet;
import java.util.Set;

class Sudoku {
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

    System.out.println(isValidSudoku_2(board));
  }


  // another implementation

  private static boolean isValidSudoku_2(char b[][]) {
    int len = b.length;

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (!isValid(b, i, j)) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean isValid(char b[][], int row, int col) {
    //check if row wise all values are unique
    if (!isValidRow(b, row)) {
      return false;
    }


    //check if col wise all values are unique
    if (!isValidCol(b, col)) {
      return false;
    }

    //check if 3*3 matrix has uniue value
    if (!isValidMatrix(b, row, col)) {
      return false;
    }

    return true;
  }

  private static boolean isValidRow(char b[][], int row) {
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      if (b[row][i] != '.') {
        if (!set.contains(b[row][i])) {
          set.add(b[row][i]);
        } else {
          return false;
        }
      }
    }
    return true;
  }


  private static boolean isValidCol(char b[][], int col) {
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      if (b[i][col] != '.') {
        if (!set.contains(b[i][col])) {
          set.add(b[i][col]);
        } else {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isValidMatrix(char b[][], int row, int col) {
    int rowS = row - row % 3;
    int colS = col - col % 3;
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (b[i + rowS][j + colS] != '.') {
          if (!set.contains(b[i + rowS][j + colS])) {
            set.add(b[i + rowS][j + colS]);
          } else {
            return false;
          }
        }
      }
    }

    return true;
  }
}


/**
 *
 *
 *
 *
 [[".",".","4",".",".",".","6","3","."],
 [".",".",".",".",".",".",".",".","."],
 ["5",".",".",".",".",".",".","9","."],
 [".",".",".","5","6",".",".",".","."],
 ["4",".","3",".",".",".",".",".","1"],
 [".",".",".","7",".",".",".",".","."],
 [".",".",".","5",".",".",".",".","."],
 [".",".",".",".",".",".",".",".","."],
 [".",".",".",".",".",".",".",".","."]]
 */