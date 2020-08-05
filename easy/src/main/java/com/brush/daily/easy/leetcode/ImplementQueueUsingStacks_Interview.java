package com.brush.daily.easy.leetcode;

import java.util.Stack;

/**
 * 面试题 03.04. 化栈为队
 * <p>
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 */
public class ImplementQueueUsingStacks_Interview {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks_Interview() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (popStack.empty()) {
            while (!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (popStack.empty() && pushStack.empty()) {
            return true;
        }
        return false;
    }

}
