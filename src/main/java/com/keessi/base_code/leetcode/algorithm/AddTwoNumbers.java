package com.keessi.base_code.leetcode.algorithm;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author SPC
 */
public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean addBit;
        ListNode head;
        if (l1.val + l2.val >= 10) {
            addBit = true;
            head = new ListNode((l1.val + l2.val) % 10);
        } else {
            addBit = false;
            head = new ListNode(l1.val + l2.val);
        }
        ListNode tail = head;
        l1 = l1.next;
        l2 = l2.next;
        while (true) {
            if (l1 != null && l2 != null) {
                if (addBit) {
                    if (l1.val + l2.val + 1 >= 10) {
                        addBit = true;
                        tail.next = new ListNode((l1.val + l2.val + 1) % 10);
                    } else {
                        addBit = false;
                        tail.next = new ListNode(l1.val + l2.val + 1);
                    }
                } else {
                    if (l1.val + l2.val >= 10) {
                        addBit = true;
                        tail.next = new ListNode((l1.val + l2.val) % 10);
                    } else {
                        addBit = false;
                        tail.next = new ListNode(l1.val + l2.val);
                    }
                }
                l1 = l1.next;
                l2 = l2.next;
                tail = tail.next;
            } else if (l1 != null) {
                if (addBit) {
                    if (l1.val + 1 >= 10) {
                        addBit = true;
                        tail.next = new ListNode((l1.val + 1) % 10);
                    } else {
                        addBit = false;
                        tail.next = new ListNode(l1.val + 1);
                    }
                } else {
                    tail.next = new ListNode(l1.val);
                }
                tail = tail.next;
                l1 = l1.next;
            } else if (l2 != null) {
                if (addBit) {
                    if (l2.val + 1 >= 10) {
                        addBit = true;
                        tail.next = new ListNode((l2.val + 1) % 10);
                    } else {
                        addBit = false;
                        tail.next = new ListNode(l2.val + 1);
                    }
                } else {
                    tail.next = new ListNode(l2.val);
                }
                tail = tail.next;
                l2 = l2.next;
            } else {
                if (addBit) {
                    tail.next = new ListNode(1);
                }
                return head;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode result=addTwoNumbers(l1, l2);
        while (result!=null) {
            System.out.print(result.val);
            if (result.next!=null)
                System.out.print("->");
            result=result.next;
        }
    }


}

