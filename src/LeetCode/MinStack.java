package LeetCode;

import java.util.Stack;

/**
 * Created by yuliu on 9/14/16.
 * Design a stack supports push, pop, top and retrieve the min ele in constant time
 * diff from normal stack getMin is to retrieve the min ele in stack
 */
public class MinStack {
    Stack<Integer> normalStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));//minStack的顶端要保证一直是最小
        }
    }

    public void pop(){
        if (normalStack.isEmpty()) {
            return;
        } else {
            normalStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (normalStack.isEmpty()) {
            return -1;
        } else {
            return normalStack.peek();
        }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        } else {
            return minStack.peek();
        }
    }

    public static void main(String args[]) {
        MinStack test = new MinStack();
        Stack<Integer> normalStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        test.push(-2);
        test.push(0);
        test.push(-3);
        System.out.println(test.getMin());
        test.pop();
        test.top();
        System.out.println(test.getMin());
    }
}
