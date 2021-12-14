package com.com.swapan.linkedlist;


import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class MergeKSortedList {

  public ListNode mergeKLists(ListNode[] lists) {
    int k = lists.length;
    Queue<ListNode> q = new PriorityQueue<>(k, (n1, n2) -> Integer.compare(n1.val, n2.val));

    for(int i =0; i< k;i++){
      if(lists[i] != null)
        q.add(lists[i]);
    }

    if(q.isEmpty()) return null;

    ListNode temp = new ListNode(0);
    ListNode last = temp;

    while(!q.isEmpty()) {
      ListNode node = q.poll();

      last.next = node;
      last = last.next;
      if(node.next!=null) {
        q.add(node.next);
      }
    }

    return temp.next;

  }
}
