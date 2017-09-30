package com.keessi.base_code.leetcode.algorithm;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        head = removeNthFromEnd(head, 2);
        for (ListNode i = head; i != null; i = i.next) {
            if (i == head) {
                System.out.print(i.val);
            } else {
                System.out.print("->" + i.val);
            }

        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        int count = 1;
        while (p != null) {
            if (count > n + 1) {
                q = q.next;
            }
            p = p.next;
            count++;
        }
        if (count <= n + 1) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
