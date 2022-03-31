package com.com.swapan.linkedlist;

public class RotateListByKSize {


  /**
   * Given the head of a linked list, rotate the list to the right by k places.
   */

  public ListNode rotateRight(ListNode head, int k) {

    ListNode tmpHead = head;

    int len = 1;

    while (tmpHead.next != null) {
      len++;
      tmpHead = tmpHead.next;
    }
    tmpHead.next = head;

    ListNode tailNode = head;
    for (int i = 0; i < len - k; i++) {
      tailNode = tailNode.next;
    }

    ListNode newHead = tailNode.next;
    tailNode.next = null; // break the link

    return newHead;
  }
}
