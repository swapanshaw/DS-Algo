package com.com.swapan.interator;

import java.util.NoSuchElementException;

public class Vector2D {
  int[][] m;
  int outer;
  int inner;

  public Vector2D(int[][] vec) {
    this.m = vec;
    this.outer = 0;
    this.inner = 0;
  }

  public int next() {

    if (!hasNext()) throw new NoSuchElementException("");

    return m[outer][inner++];
  }

  public boolean hasNext() {
    goToNext();
    System.out.println(outer + " " + inner);
    return outer < m.length && inner < m[outer].length;
  }

  private void goToNext() {
    if (outer < m.length && inner == m[outer].length) {
      outer++;
      inner = 0;
    }
  }


  public static void main(String[] args) {
    int[][] vec = new int[][]{
            {1, 2}, {3}, {4}
    };

    Vector2D vector2D = new Vector2D(vec);

    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
  }
}
