package com.com.swapan.linkedlist;

public class RemoveKthNodeEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;

    int len = 0;

    ListNode first = head;
    while (first != null) {
      len++;
    }

    System.out.println("len " + len);
    first = head;
    while (len > 0) {
      len--;
      first = first.next;
    }

    first.next = first.next.next;

    return head;

  }
}
