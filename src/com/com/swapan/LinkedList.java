package com.com.swapan;

public class LinkedList {

  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node adTwoLinkedList(Node first, Node second) {
    int carry = 0;
    int sum = 0;
    Node res = null;
    Node prev = null;
    while (first != null || second != null) {

      sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);

      carry = sum > 10 ? 1 : 0;

      Node temp = new Node(sum % 10);
      if (res == null) {
        res = temp;
      } else {
        prev.next = temp;
      }
      prev = temp;

      if(first.next!=null) {
        first = first.next;
      }

      if(second.next != null) {
        second = second.next;
      }
    }

    if(carry > 0) {
      res.next = new Node(carry);
    }

    return res;
  }


  //Driver
  public static void main(String[] args) {

  }
}
