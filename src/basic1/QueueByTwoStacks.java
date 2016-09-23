package basic1;

import java.util.Stack;

/**
 * Created by yuliu on 3/13/16.int int[]
 */
public class QueueByTwoStacks {
    private Stack<Integer> stack1;//queue后半段
    private Stack<Integer> stack2;//queue前半段

    //stack1 is used for push
    //stack2 is used for pop from stack1 and push them into stack2
    public QueueByTwoStacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public Integer poll() {//poll delete in queue
        if (stack1.isEmpty() && stack2.isEmpty()) return null;
        else if (!stack2.isEmpty()) return stack2.pop();
        else {move(); return stack2.pop();}
    }

    public void offer(int value) {
        //constantly push sth to stack1
        stack1.push(value);
    }

    public Integer peek() {//top
        if (stack1.isEmpty() && stack2.isEmpty()) return null;
        else if (!stack2.isEmpty()) return stack2.peek();
        else {move(); return stack2.peek();}
    }
    //move elements from stack1 to stack2
    private void move() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
    //return the number of items in the queue
    public int size() {
        return stack1.size() + stack2.size();
    }
    //is the queue empty?
    public boolean isEmpty() {
        return stack1.size() == 0 && stack2.size() == 0;
    }



    public static void main(String[] args) {
        QueueByTwoStacks test = new QueueByTwoStacks();
//        Scanner sc = new Scanner(System.in);
//        int value = sc.nextInt();
//        System.out.println("input the queue:");
//        while(sc.nextInt() != null) {
//
//        }

        test.offer(1);
        test.offer(2);
        test.offer(3);
        test.offer(4);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.isEmpty());
        System.out.println(test.size());

    }


}
