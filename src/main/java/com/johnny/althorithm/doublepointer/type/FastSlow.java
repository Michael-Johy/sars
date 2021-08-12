package com.johnny.althorithm.doublepointer.type;

import com.johnny.althorithm.doublepointer.ListNode;

public class FastSlow {

    public static void main(String[] args) {
        FastSlow fastSlow = new FastSlow();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l2;

        System.out.println(fastSlow.hasCycle(l1));
        System.out.println(fastSlow.cycleStartNode(l1).value);

        FastSlow fastSlow1 = new FastSlow();
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode lastN = fastSlow1.lastN(l11, 7);
        if (null == lastN) {
            System.out.println("not exist");
        } else {
            System.out.println(lastN.value);
        }
    }

    public ListNode lastN(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n >= 0 && null != fast) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return null;
        }

        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode remove = slow.next;
        slow.next = slow.next.next;
        return remove;
    }

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算环的长度和环起始节点
     */
    public ListNode cycleStartNode(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode fast = head, slow = head;
        int i = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            i++;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        System.out.println("i = " + i);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
