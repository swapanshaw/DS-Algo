package com.com.swapan.array;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

  public static void main(String[] args) {
    BinarySearch bs = new BinarySearch();
    /*int arr[] = {10, 20, 40, 60, 5, 8};
    System.out.println(bs.searchInSortedRotatedArray(arr, 8));*/

    int a1[] = {1,2}, n1 = 5, a2[] = {3,4}, n2 = 5;
    System.out.println(bs.medianOfTwoSortedArray(a1, a2));

    //int[] arr = {4, 5, 6, 7, 1, 2};

    //System.out.printf(String.valueOf(findElementInRotatedSortedArray(arr, 1)));
  }

  static int findElementInRotatedSortedArray(int[] arr, int key) {
    int len = arr.length;

    if (len < 1) {
      return -1;
    }

    int pivot = findPivotElement(arr, 0, len);
    //System.out.printf(String.valueOf(pivot));
    // seach using binary search
    if (key == arr[pivot])
      return pivot;
    if (arr[0] <= key)
      return binarySearch(arr, 0, pivot - 1, key);
    else
      return binarySearch(arr, pivot + 1, len - 1, key);
  }

  private static int binarySearch(int[] arr, int low, int high, int key) {
    if (high < low)
      return -1;

    int mid = (low + high )/ 2;

    if (key == arr[mid])
      return mid;

    if (key < arr[mid])
      return binarySearch(arr, low, mid - 1, key);
    else
      return binarySearch(arr, mid + 1, high, key);
  }

  static int findPivotElement(int[] arr, int low, int high) {

    if (high < low) return -1;

    int mid = low + high / 2;

    if (mid < high && arr[mid] > arr[mid + 1]) {
      return mid;
    }

    if (mid > low && arr[mid] < arr[mid - 1]) {
      return mid;
    }

    if (arr[mid] > arr[low]) {
      return findPivotElement(arr, mid + 1, high);
    } else {
      return findPivotElement(arr, low, mid - 1);
    }
  }

  public int lastOcc(int[] arr, int x) {
    int n = arr.length;

    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (x < arr[mid]) {
        high = mid - 1;
      } else if (x > arr[mid]) {
        low = mid + 1;
      } else {
        if ((mid == n - 1) || (arr[mid] != arr[mid + 1]))
          return mid;
        else
          low = mid + 1;
      }
    }
    return -1;
  }


  int searchInSortedRotatedArray(int arr[], int x) {
    int n = arr.length;
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == x) {
        return mid;
      } else if (arr[low] < arr[mid]) {
        if (x >= arr[low] && x < arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (x > arr[mid] && x <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }


  int medianOfTwoSortedArray(int[] arr1, int[] arr2) {

    int n = arr1.length;
    int m = arr2.length;

    int a1[] = n <= m ? arr1 : arr2;
    int a2[] = m >= n ? arr2 : arr1;

    int n1 = n <= m ? n : m;
    int n2 = n >= m ? n : m;

    int low = 0;
    int high = n1;


    while (low < high) {
      int i1 = (low + high) / 2;
      int i2 = (n + m + 1) / 2 - i1;

      int min1 = (i1 == n1) ? Integer.MAX_VALUE : a1[i1];
      int max1 = (i1 == 0) ? Integer.MIN_VALUE : a1[i1 - 1];

      int min2 = (i2 == n2) ? Integer.MAX_VALUE : a2[i2];
      int max2 = (i2 == 0) ? Integer.MIN_VALUE : a2[i2 - 1];

      if (max1 <= min2 && min1 >= max2) {
        if ((m + n) % 2 == 0) {
          return (Integer.max(max1, max2) + Integer.min(min1, min2)) / 2;
        } else {
          return Integer.max(max1, max2);
        }
      } else if (max2 > min1) {
        low = i1 + 1;
      } else {
        high = i1 - 1;
      }
    }
    return -1;
  }

  /**
   * Duplicate
   */
  List<Integer> findDuplicates(int[] arr) {
    List<Integer> result = new ArrayList<>();
    for (Integer n : arr) {
      n = Math.abs(n);

      if (arr[n] > 0) {
        arr[n] *= -1;
      } else {
        result.add(n);
      }
    }
    return result;
  }

  /**
   * To set any bit we use bitwise OR | operator. As we already know bitwise OR | operator evaluates each bit of the
   * result to 1 if any of the operand’s corresponding bit is set (1). In-order to set kth bit of a number we need to
   * shift 1 k times to its left and then perform bitwise OR operation with the number and result of left shift performed just before
   * <p>
   * Kth bit masking
   *
   * @param n
   * @param k
   * @return
   */
  static int setKthBit(int n, int k) {
    // kth bit of n is being set by this operation
    return ((1 << k) | n);
  }

  /**
   * Moor's algo
   *
   * @param arr
   * @return
   */
  int findMajorityOfElement(int[] arr) {

    int cand = findCandidate(arr);
    int count = 0;
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      if (cand == arr[i]) {
        count++;
      }
    }

    if (count > len / 2) {
      return cand;
    }
    return -15845897;
  }

  private int findCandidate(int[] arr) {
    int maj_index = 0, count = 1;
    //find candidate
    int cand = 0;
    for (int i = 1; i < arr.length; i++) {

      if (arr[i] == arr[maj_index]) {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        maj_index = i;
        count = 1;
      }
    }

    return arr[maj_index];
  }

}
