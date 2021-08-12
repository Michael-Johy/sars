package com.johnny.althorithm.datastruct.linkedlist;

public class HuiWen {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        HuiWen huiWen = new HuiWen();
//        System.out.println(huiWen.byTraverse(l1));

        System.out.println(huiWen.slowFastPointer(l1));

    }

    private ListNode left;

    /**
     * 必须跳出全部迭代过程，才可以判断是否是回文
     */
    private boolean byTraverse(ListNode head) {
        left = head;
        return doByTraverse(head);
    }

    private boolean doByTraverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean isOK = doByTraverse(head.next);
        isOK = isOK && (head.value == left.value);
        left = left.next;
        return isOK;
    }


    /**
     * 快慢指针
     */
    public boolean slowFastPointer(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode pre = reverse(slow);
        while (pre != null && head != null) {
            if (pre.value != head.value) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode nxt;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            nxt = cur.next;

            cur.next = pre;
            pre = cur;

            cur = nxt;
        }
        return pre;
    }
}
