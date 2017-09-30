package com.keessi.base_code.leetcode.algorithm;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode p = l1, q = l2;
        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i * 3);
            q.next = new ListNode(i * 2);
            p = p.next;
            q = q.next;
        }
        ListNode head = mergeTwoLists(l1, l2);
        for (ListNode i = head; i != null; i = i.next) {
            if (i == head) {
                System.out.print(i.val);
            } else {
                System.out.print("->" + i.val);
            }

        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode res, p, q;
            if (l1.val < l2.val) {
                res = new ListNode(l1.val);
                p = l1.next;
                q = l2;
            } else {
                res = new ListNode(l2.val);
                p = l1;
                q = l2.next;
            }
            ListNode cur = res;
            while (p != null || q != null) {
                if (p == null) {
                    cur.next = new ListNode(q.val);
                    q = q.next;
                } else if (q == null) {
                    cur.next = new ListNode(p.val);
                    p = p.next;
                } else {
                    if (p.val < q.val) {
                        cur.next = new ListNode(p.val);
                        p = p.next;
                    } else {
                        cur.next = new ListNode(q.val);
                        q = q.next;
                    }
                }
                cur = cur.next;
            }
            return res;
        }
    }
}
