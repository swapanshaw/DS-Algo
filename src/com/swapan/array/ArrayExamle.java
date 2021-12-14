package com.swapan.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayExamle {
  public static void main(String[] args) {
    ArrayExamle arrayExamle = new ArrayExamle();
    //int[] arr = {1,8,6,2,5,4,8,3,7};
    int[] arr = {4, 2, 0, 3, 2, 5};
    int[] arr1 = {3, 1};
    System.out.println(arrayExamle.searchInRoatedSortedArray(arr1, 1));
    /*System.out.println("Largest element: " + arrayExamle.largestElement(arr));
    System.out.println("2nd Largest element: " + arrayExamle.secondLargestElement(arr));
    System.out.println("isSorted array: " + arrayExamle.isArraySorted(arr));
    System.out.println("index after removing duplicate from array: " + arrayExamle.removeDuplicate(arr));


    arrayExamle.reverseArray(arr);
    for (int i : arr) {
      System.out.println(i);
    }*/

    //arrayExamle.rotateArrayOptimal(arr, 2);

    //System.out.println(arrayExamle.maxProfit(arr1, 0, arr1.length));
    //System.out.println(arrayExamle.maxProfitEfficient(arr1));

    //System.out.println(arrayExamle.maxSubArraySum(arr1));
    //System.out.println(arrayExamle.maximumSumArraySumCircular(arr1));

    //System.out.println(arrayExamle.maximumSumArraySumCircularNaive(arr1));

    /*for (int i : arr) {
      System.out.println(i);
    }*/
  }

  int largestElement(int[] arr) {
    final int len = arr.length;
    int largestElement = arr[0];

    for (int i = 1; i < len; i++) {

      if (arr[i] > largestElement) {
        largestElement = arr[i];
      }
    }

    return largestElement;
  }

  int secondLargestElement(int[] arr) {
    final int len = arr.length;
    if (len < 2)
      return -1;

    int max1 = Math.max(arr[0], arr[1]);
    int max2 = Math.min(arr[0], arr[1]);

    if (len == 2)
      return max2;

    for (int i = 2; i < len; i++) {
      if (arr[i] > max1) {
        max1 = arr[i];
        if (i != len - 1)
          max2 = max1;

      } else if (arr[i] > max2) {
        max2 = arr[i];
      }

    }
    return max2;

  }

  boolean isArraySorted(int[] arr) {
    final int len = arr.length;
    if (len == 1) return true;

    for (int i = 1; i < len; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }
    return true;
  }

  void reverseArray(int arr[]) {
    final int len = arr.length;

    if (len == 1) return;
    int low = 0;
    int high = len - 1;

    while (low < high) {
      swap(low, high, arr);
      low++;
      high--;
    }
  }

  int removeDuplicate(int arr[]) {
    int len = arr.length;
    int res = 1;

    for (int i = 1; i < len; i++) {
      if (arr[i] != arr[res - 1]) {
        arr[res] = arr[i];
        res++;
      }
    }
    return res;
  }

  /**
   * with aux space
   */
  void rotateArrayByPosition(int arr[], int d) {
    int len = arr.length;
    if (d < 1) {
      return;
    }
    int temp[] = new int[d];

    for (int i = 0; i < d; i++) {
      temp[i] = arr[i];
    }

    for (int i = d; i < len; i++) {
      arr[i - d] = arr[i];
    }

    for (int i = 0; i < d; i++) {
      arr[len - d + i] = temp[i];
    }
  }

  void rotateArrayOptimal(int arr[], int d) {
    if (d < 1) {
      return;
    }
    int len = arr.length;

    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, len - 1);
    reverseArray(arr, 0, len - 1);
  }

  void leaderInArray(int[] arr) {
    int len = arr.length;
    int res = len - 1;
    System.out.println(arr[res]);
    for (int i = len - 2; i >= 0; i--) {
      if (arr[i] > arr[res]) {
        System.out.println(arr[i]);
        res = i;
      }
    }
  }

  /**
   * Maximum Difference problem is to find the maximum of arr[j] - arr[i] where j>i.
   *
   * @param arr
   * @return
   */
  int maxDiff(int[] arr) {
    int len = arr.length;
    int maxDiff = arr[1] - arr[0];
    int minValue = arr[0];


    for (int i = 1; i < len; i++) {
      maxDiff = Math.max(maxDiff, arr[i] - minValue);
      minValue = Math.min(minValue, arr[i]);
    }

    return maxDiff;
  }

  /**
   * naive solution to the Stock Buy and Sell Problem.
   *
   * @param arr
   * @param start
   * @param end
   */

  int maxProfit(int arr[], int start, int end) {
    if (end <= start) {
      return 0;
    }
    int profit = 0;

    for (int i = start; i < end; i++) {
      for (int j = i + 1; j < end; j++) {
        if (arr[j] > arr[i]) {
          int currentProfit = (arr[j] - arr[i]) + maxProfit(arr, start, i - 1) + maxProfit(arr, j + 1, end);
          profit = Math.max(profit, currentProfit);
        }
      }
    }
    return profit;
  }

  /**
   * Efficient solution to the Stock Buy and Sell Problem.
   *
   * @param arr
   * @return
   */
  int maxProfitEfficient(int[] arr) {
    if (arr.length == 1)
      return 0;
    int profit = 0;
    for (int i = 1; i < arr.length; i++) {
      int diff = arr[i] - arr[i - 1];
      if (diff > 0) {
        profit += diff;
      }
    }

    return profit;
  }

  int getMaxRainWaterTapped(int arr[]) {
    int len = arr.length;

    int lMax[] = new int[len];
    int rMax[] = new int[len];
    lMax[0] = arr[0];
    rMax[len - 1] = arr[len - 1];
    for (int i = 1; i < len; i++) {
      lMax[i] = Math.max(arr[i], lMax[i - 1]);
    }

    for (int i = len - 2; i >= 0; i--) {
      rMax[i] = Math.max(arr[i], rMax[i + 1]);
    }
    int result = 0;
    for (int i = 1; i < len - 1; i++) {
      if (arr[i] < lMax[i] && arr[i] < rMax[i])
        result += (Math.min(lMax[i], rMax[i]) - arr[i]);
    }


    return result;
  }


  int maConsesutiveOne(int[] arr) {

    int curr = 0;
    int max = 0;

    for (int i = 0; i < arr.length; i++) {

      if (arr[i] == 0) {
        curr = 0;
      } else {
        curr++;
        max = Math.max(max, curr);
      }
    }

    return max;
  }

  /**
   * using Kandes algo
   *
   * @param arr
   * @return
   */
  int maxSubArraySum(int arr[]) {
    int len = arr.length;

    int maxEndingSum = arr[0];
    int result = arr[0];

    for (int i = 1; i < len; i++) {
      maxEndingSum = Math.max(maxEndingSum + arr[i], arr[i]);
      result = Math.max(result, maxEndingSum);
    }

    return result;
  }

  //Naive
  int maximumSumArraySumCircularNaive(int arr[]) {
    int len = arr.length;
    int maxSum = arr[0];
    for (int i = 0; i < len; i++) {
      int currSum = arr[i];
      for (int j = i + 1; j < len; j++) {
        int index = (i + j) % len;
        currSum = Math.max(currSum + arr[index], arr[index]);
        maxSum = Math.max(maxSum, currSum);
      }
    }
    return maxSum;
  }

  //Efficient O(n)
  int maximumSumArraySumCircular(int arr[]) {
    int maxSubArraySum = maxSubArraySum(arr);

    if (maxSubArraySum < 0) {
      return maxSubArraySum;
    }

    int sumArr = 0;
    for (int i = 0; i < arr.length; i++) {
      sumArr += arr[i];
      arr[i] = -arr[i];
    }

    int maxCircularSumArrSum = sumArr + maxSubArraySum(arr);

    return Math.max(maxCircularSumArrSum, maxSubArraySum);
  }


  /**
   * using Kanden algo
   *
   * @param arr
   * @return
   */
  int maxEvenOdd(int arr[]) {
    int curr = 1;
    int result = 1;

    for (int i = 1; i < arr.length; i++) {
      if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
        curr++;
        result = Math.max(result, curr);
      } else {
        curr = 1;
      }
    }
    return result;
  }

  //Using Moore’s Voting Algorithm):

  /**
   * Loop through each element and maintains a count of majority element, and a majority index, maj_index
   * If the next element is same then increment the count if the next element is not same then decrement the count.
   * if the count reaches 0 then changes the maj_index to the current element and set the count again to 1.
   * Now again traverse through the array and find the count of majority element found.
   * If the count is greater than half the size of the array, print the element
   * Else print that there is no majority element
   */
  int majorityElement(int arr[]) {
    int majIndex = 0;
    int count = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[majIndex]) {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        majIndex = i;
        count = 1;
      }
    }
    count = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[majIndex] == arr[i]) {
        count++;
      }
    }

    if (count >= arr.length / 2) {
      return majIndex;
    } else {
      return -1;
    }
  }

  /**
   * Sliding time window
   *
   * @param arr
   */
  void subArraySum(int arr[], int sum) {
    int len = arr.length;
    int currSum = 0;
    int start = 0;
    int end = 0;
    for (int i = 0; i < len; i++) {

      if (currSum == sum) {
        end = i;
        System.out.println("start=" + start + "end=" + end);
        break;
      }

      while (currSum > sum && start < i) {
        currSum = currSum - arr[start];
        start = i;
      }

      currSum = +arr[i];
    }
  }

  public int subarraySumEquslK(int[] nums, int k) {

    Map<Integer, Integer> freq = new HashMap<>();
    int sum = 0;
    int res = 0;
    freq.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int diff = sum - k;

      if (freq.containsKey(diff)) {
        res += freq.get(diff);
      }

      freq.put(sum, freq.getOrDefault(sum, 0) + 1);

    }

    return res;

  }


  public int searchInRoatedSortedArray(int[] nums, int target) {
    int l = 0;
    int r = nums.length;

    while (l <= r) {
      int m = (l + r - 1) / 2;
      if (nums[m] == target) return m;

      if (nums[l] <= nums[m]) {
        if (target >= nums[l] && target <= nums[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      } else {
        if (target >= nums[m] && target <= nums[r]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }

    }

    return -1;
  }

  private void reverseArray(int[] arr, int low, int high) {

    while (low < high) {
      swap(low, high, arr);
      low++;
      high--;
    }
  }

  private void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


}
