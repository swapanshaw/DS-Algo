package com.com.swapan.linkedlist;

/*class ListNode {
  int val;
  ListNode next;

  ListNode(int _val) {
    this.val = _val;
    this.next = null;
  }
}*/

public class RotateLinkedListKPos {
  /**
   * Given the head of a linked list, rotate the list to the right by k places.
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;

    if (head.next == null) return head;

    int n = 0;
    ListNode oldTail = head;
    for (n = 1; oldTail.next != null; n++) {
      oldTail = oldTail.next;
    }
    // last node point to head;
    oldTail.next = head;

    // find new Tail at n-k%n -1 position
    // find new nead at n - k%n position
    ListNode newTail = head;
    for (int i = 0; i < n - k % n - 1; i++) {
      newTail = newTail.next;
    }

    ListNode newHead = newTail.next;
    newTail.next = null;

    return newHead;
  }


}
