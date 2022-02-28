package com.com.swapan.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SwapNodeInPair {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        
        
        ListNode curr = head;
        //ListNode prev=null, next = null;
        
        while(curr!=null && curr.next!=null) {
            //swap the data
            int temp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = temp;
            curr=curr.next.next;
        }
        return head;
    }
}