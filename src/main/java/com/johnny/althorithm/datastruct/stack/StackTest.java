package com.johnny.althorithm.datastruct.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 单调栈：解决next greater number
 */
public class StackTest {

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        int[] nums = new int[]{2, 1, 2, 4, 3};
        LinkedList<Integer> result = stackTest.solve(nums);
        for (Integer item : result) {
            System.out.println(item);
        }
    }

    public LinkedList<Integer> solve(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            int a = stack.isEmpty() ? -1 : stack.peek();
            list.addFirst(a);
            stack.push(nums[i]);
        }
        return list;
    }

}
