package com.brush.daily.easy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementQueueUsingStacks_InterviewTest {



    @Test
    public void test() {
        ImplementQueueUsingStacks_Interview queue = new ImplementQueueUsingStacks_Interview();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());
    }

}