package basic1;

import java.util.Stack;

/**
 * Created by yuliu on 3/14/16.
 */
//public class StackWithMin {
//
//    private Stack<Integer> globalmin;
//    private Stack<Integer> stack;
//    private int minvalue = Integer.MAX_VALUE;
//
//    public StackWithMin() {
//        globalmin = new Stack<Integer>();
//        stack = new Stack<Integer>();
//    }
//
//    public Integer pop() {
//        if (stack.empty()) return -1;
//        //int result = stack.pop();
//        else if (globalmin.peek().equals(stack.peek())) {
//            globalmin.pop();
//        }
//        return stack.pop();
//    }
//
//    public void push(int element) {
//        stack.push(element);
//        if (element < minvalue) {
//            minvalue = element;
//            globalmin.push(element);
//        }
//        else globalmin.push(minvalue);
//    }
//
//    public Integer top() {
//        if (stack == null) return -1;
//        else return stack.peek();
//    }
//
//    public Integer min() {
//        //current = stack.peek()
//        if (stack == null) return -1;
//        else return globalmin.peek();
//    }




public class StackWithMin {

    private Stack<Integer> globalmin;
    private Stack<Integer> stack;
    private int minvalue = Integer.MAX_VALUE;

    public StackWithMin() {
        globalmin = new Stack<Integer>();
        stack = new Stack<Integer>();
    }
///================================================
    public Integer pop() {
        if (stack == null|| stack.isEmpty()) return -1;
            else {
            globalmin.pop();
            return stack.pop();
        }
    }
//------------------------------------------------
    public void push(int element) {

        if (element < minvalue) {
            minvalue = element;
            globalmin.push(element);
        }
        else globalmin.push(minvalue);
        stack.push(element);
    }
//----------------------------------------------------
    public Integer top() {
        if (stack == null|| stack.isEmpty()) return -1;
        else return stack.peek();
    }
//------------------------------------------------------
    public Integer min() {
        //current = stack.peek()
        if (stack == null || stack.isEmpty()) return -1;
        else return globalmin.peek();
    }


    public static void main(String[] args) {
        StackWithMin test = new StackWithMin();

        test.push(4);
        test.push(7);
        test.push(1);
        test.push(-99);
        test.pop();
        test.pop();

        System.out.print(test.min());
    }

}
