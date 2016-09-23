package Important;

import java.util.*;

/**
 * Created by yuliu on 9/6/16.
 * Given a nested list of integers, implement an iterator to flatten it
 * Each element is either an integer or a list whose elements may also be integers or other lists
 * [[1,1],2,[3,5]] ----> [1,1,2,3,5]
 * [[1,1],2,[3,5],8,[9,[10]]]  ----> [1,1,2,3,5,8,9,10]
 *
 * Use a stack to access each NestedInteger at a time
 * In the constructor, we push all the nestedList into the stack from back to front
 * when we pop the stack, it return the very first element
 *
 * second, in the hasNext() fuction, we peek the first in stack currenly , if it is an integer,
 * we will return true and pop the element
 *
 * if it is a list, we will further flatten it.
 */
public class FlattenNestedListIterator {
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {//定义类
        Deque<NestedInteger> deque = new LinkedList<>();
        public NestedIterator(List<NestedInteger> nestedlist) {//constructor
            for (NestedInteger ni : nestedlist) {
                if (ni != null) {
                    deque.offerLast(ni);
                }
            }
        }

        @Override
        public boolean hasNext() {
            while(!deque.isEmpty()) {
                NestedInteger cur = deque.peekFirst();
                if (cur.isInteger()) {
                    return true;
                }
                deque.removeFirst();
                for (NestedInteger in : cur.getList()) {
                    deque.offerLast(in);
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            return deque.peekLast().getInteger();
        }
    }
    public static void main(String args[]) {
        FlattenNestedListIterator test = new FlattenNestedListIterator();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.iterator().next();
        Iterator wo = list.iterator();
        wo.remove();
        System.out.println(list.iterator().hasNext());
        System.out.println(list.iterator().next());

    }
}
