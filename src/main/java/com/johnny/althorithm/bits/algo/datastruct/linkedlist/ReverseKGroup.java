package com.johnny.althorithm.bits.algo.datastruct.linkedlist;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head){
            return null;
        }
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                break;
            }
            b = b.next;
        }
        ListNode newNode = reverse(head, b);
        head.next = reverseKGroup(b, k);
        return newNode;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode nxt;
        ListNode pre = null;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
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
        ReverseKGroup  reverseKGroup = new ReverseKGroup();
        ListNode head = reverseKGroup.reverseKGroup(l1, 2);
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }

    }

}
