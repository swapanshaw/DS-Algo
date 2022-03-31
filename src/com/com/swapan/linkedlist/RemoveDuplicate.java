package com.com.swapan.linkedlist;

public class RemoveDuplicate {

  static ListNode deleteDuplicates(ListNode head) {

    ListNode senital = new ListNode(0);

    ListNode pred = senital;

    while (head != null) {

      if (head.next != null && head.val == head.next.val) {

        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        pred.next = head.next;
      } else {
        pred = pred.next;
      }
      head = head.next;
    }

    return pred;
  }
}
