package com.com.swapan.ds.matrix;

// Java program to check if the word
// exists in the grid or not
class WordSerachInGrid {

  static final int r = 3;
  static final int c = 4;

  // Function to check if a word exists in a grid
// starting from the first match in the grid
// level: index till which pattern is matched
// x, y: current position in 2D array
  static boolean findmatch(char mat[][], String pat, int x, int y,
                           int nrow, int ncol, int level) {
    int l = pat.length();

    // Pattern matched
    if (level == l)
      return true;

    // Out of Boundary
    if (x < 0 || y < 0 || x >= nrow || y >= ncol)
      return false;

    // If grid matches with a letter while
    // recursion
    if (mat[x][y] == pat.charAt(level)) {

      // Marking this cell as visited
      char temp = mat[x][y];
      mat[x][y] = '#';

      // finding subpattern in 4 directions
      boolean res = findmatch(mat, pat, x - 1, y, nrow, ncol, level + 1) |
              findmatch(mat, pat, x + 1, y, nrow, ncol, level + 1) |
              findmatch(mat, pat, x, y - 1, nrow, ncol, level + 1) |
              findmatch(mat, pat, x, y + 1, nrow, ncol, level + 1);

      // marking this cell
      // as unvisited again
      mat[x][y] = temp;
      return res;
    } else // Not matching then false
      return false;
  }

  // Function to check if the word exists in the grid or not
  static boolean checkMatch(char mat[][], String pat, int nrow, int ncol) {

    int l = pat.length();

    // if total characters in matrix is
    // less then pattern lenghth
    if (l > nrow * ncol)
      return false;

    // Traverse in the grid
    for (int i = 0; i < nrow; i++) {
      for (int j = 0; j < ncol; j++) {

        // If first letter matches, then recur and check
        if (mat[i][j] == pat.charAt(0))
          if (findmatch(mat, pat, i, j, nrow, ncol, 0))
            return true;
      }
    }
    return false;
  }

  // Driver Code
  public static void main(String[] args) {
    char grid[][] = {"ABCDE".toCharArray(),
            "SFCS".toCharArray(),
            "ADEE".toCharArray(),
    };

    // Function to check if word exists or not
    if (checkMatch(grid, "ABCCED", r, c))
      System.out.print("Yes");
    else
      System.out.print("No");
  }
}

// This code is contributed by 29AjayKumar
