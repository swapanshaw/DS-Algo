package com.swapan.array;

public class ArrayExamle {
  public static void main(String[] args) {
      ArrayExamle arrayExamle = new ArrayExamle();
      int []arr = {9,9,10,24,50,60,65,76, 80,20, 20};

    System.out.println("Largest element: " + arrayExamle.largestElement(arr));
    System.out.println("2nd Largest element: " + arrayExamle.secondLargestElement(arr));
    System.out.println("isSorted array: " + arrayExamle.isArraySorted(arr));
    System.out.println("index after removing duplicate from array: " + arrayExamle.removeDuplicate(arr));

    arrayExamle.reverseArray(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  int largestElement(int []arr) {
    final int len = arr.length;
    int largestElement = arr[0];

    for (int i = 1; i< len; i++) {

      if(arr[i] > largestElement) {
        largestElement = arr[i];
      }
    }

    return largestElement;
  }

  int secondLargestElement(int []arr) {
    final int len = arr.length;
    if(len < 2)
      return -1;

    int max1 = Math.max(arr[0], arr[1]);
    int max2 = Math.min(arr[0], arr[1]);

    if (len == 2)
      return max2;

    for(int i = 2; i<len; i++) {
      if(arr[i] > max1) {
        max1 = arr[i];
        if (i != len-1)
          max2 = max1;

      } else if(arr[i] > max2){
        max2 =arr[i];
      }

    }
    return max2;

  }

  boolean isArraySorted(int []arr) {
    final int len = arr.length;
    if(len == 1) return true;

    for (int i = 1; i< len; i++) {
      if(arr[i] < arr[i-1]) {
        return false;
      }
    }
    return true;
  }

  void reverseArray(int arr[]) {
    final int len = arr.length;

    if(len == 1) return;
    int low = 0;
    int high=len-1;

    while(low < high) {
      swap(low, high, arr);
      low++;
      high--;
    }
  }

  int removeDuplicate(int arr[]) {
    int len = arr.length;
    int res = 1;

    for(int i = 1; i<len; i++) {
      if(arr[i] != arr[res-1]) {
        arr[res]=arr[i];
        res++;
      }
    }
    return res;
  }

  private void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


}
