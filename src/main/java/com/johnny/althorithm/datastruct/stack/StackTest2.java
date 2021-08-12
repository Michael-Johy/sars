package com.johnny.althorithm.datastruct.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 去重，不破坏之前的顺序，且字典序最小
 */
public class StackTest2 {
    public static void main(String[] args) {
        StackTest2 stackTest2 = new StackTest2();
        LinkedList<Character> result = stackTest2.solve("bcabc");
        for (Character c : result){
            System.out.println(c);
        }
    }

    public LinkedList<Character> solve(String s) {
        LinkedList<Character> result = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (stack.contains(item)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek().compareTo(item) > 0 && s.indexOf(item, i) > 0) {
                stack.pop();
            }
            stack.push(item);
        }
        while (!stack.isEmpty()){
            result.addFirst(stack.pop());
        }
        return result;
    }

}
