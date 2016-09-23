package Important;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 9/5/16.
 * Given a linkedlist such that each node contains an additional random pointer which could point to any node
 * in the list or null.
 * Return a deep copy of the list
 */
public class CopyListWithRandomPointer {
    static class RandomListNode{
        int label;
        RandomListNode next;
        RandomListNode random;
        RandomListNode(int x) {
            this.label = x;
        }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode pre = new RandomListNode(0);
        RandomListNode cur = head;
        RandomListNode newNode;
        RandomListNode newRandom;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, new RandomListNode(cur.label));
            }
            newNode = map.get(cur);
            pre.next = newNode;
            pre = pre.next;
            if(cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    map.put(cur.random, new RandomListNode(cur.random.label));
                }
                newRandom = map.get(cur.random);
                pre.random = newRandom;
            }
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String args[]) {
        CopyListWithRandomPointer test = new CopyListWithRandomPointer();
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        one.next = two;
        two.next = three;
        three.random = one;
        two.random = three;
        test.copyRandomList(one);
    }
}
