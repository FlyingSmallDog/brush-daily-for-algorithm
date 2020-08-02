package com.brush.daily.medium.leetcode;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbers_2Test {

    private AddTwoNumbers_2 testMethod = new AddTwoNumbers_2();

    @Test
    void addTwoNumbers() {
        //test1
        /*AddTwoNumbers_2.ListNode l1 = new AddTwoNumbers_2.ListNode(2);
        l1.next = new AddTwoNumbers_2.ListNode(4);
        l1.next.next = new AddTwoNumbers_2.ListNode(3);
        AddTwoNumbers_2.ListNode l2 = new AddTwoNumbers_2.ListNode(5);
        l2.next = new AddTwoNumbers_2.ListNode(6);
        l2.next.next = new AddTwoNumbers_2.ListNode(4);*/
        AddTwoNumbers_2.ListNode l1 = new AddTwoNumbers_2.ListNode(5);
        AddTwoNumbers_2.ListNode l2 = new AddTwoNumbers_2.ListNode(5);
        AddTwoNumbers_2.ListNode result = testMethod.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}