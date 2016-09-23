package basic2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 6/30/16.
 */
//Method1: Using HashMap to avoid copy multiple
public class DeepCopyLinkedListWithRandomPointer {
    //definition for singly-linked list with a random pointer.
    class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;
        RandomListNode(int value) {
            this.value = value;
        }
    }
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return null;
        }
        //set line1 node to help construct the deep copy.
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        //maintains the mapping between the node in the original list and the corresponding node in the new list
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        while (head != null) {
            //we can start to copy current node if necessary
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            //connect the copied node to the deep copy list
            cur.next = map.get(head);
            //copy the random node if necessary

            if(head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                //connect the copied node to the random pointer.
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
