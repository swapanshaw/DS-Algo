package com.com.swapan.backtracking;


import java.util.HashSet;
import java.util.Set;

public class Sudoku {
  private static int ROW = 9;
  private static int COL = 9;
  boolean isValidSudoku(char[][] board) {

    int row = board.length;
    int col = board[0].length;

    // if matric is not N*N
    if(row != ROW || col != COL) return false;


    for(int i = 0; i< ROW;i++) {
      for(int j = 0; j< COL; j++) {
        if(!isValid(board,i,j))
          return false;
      }
    }

    return true;

  }

  private boolean isValid(char[][] b, int i, int j) {
    // check for duplicate value in row
    return (isValidRow(b, i)
            // check for duplucate value is col
            && isValidCol(b, j)
            // is valid 3*3 matrix
            && isValidThreXThreee(b, i, j)
    );
  }

  private boolean isValidRow(char [][]b, int row) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i<COL;i++) {
      if(b[row][i] != '.') {
        if(set.contains(b[row][i])) {
          return false;
        }else {
          set.add(b[row][i]);
        }
      }
    }
    return true;
  }


  private boolean isValidCol(char [][]b, int col) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i< ROW;i++) {
      if(b[i][col] != '.') {
        if(set.contains(b[i][col] )) {
          return false;
        }else {
          set.add(b[i][col]);
        }
      }
    }
    return true;
  }

  private boolean isValidThreXThreee(char[][] b, int row, int col) {
    Set<Character> set = new HashSet<>();

    int rowN = row - row%3;
    int colN = col - col%3;

    for(int i=0; i<3;i++) {
      for(int j =0; j<3;j++) {
        if(b[i+rowN][j+colN] != '.') {
          if(set.contains(b[i+ rowN][j+colN])) {
            return false;
          } else {
            set.add(b[i+rowN][j+colN]);
          }
        }
      }
    }

    return true;
  }

}