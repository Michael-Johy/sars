package com.johnny.althorithm.datastruct.linkedlist;

public class ReverseBetween {

    private ListNode tail;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = reverseBetween.reverseBetween(l1, 2, 4);
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            tail = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tail;
        return last;
    }
}
