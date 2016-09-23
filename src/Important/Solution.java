package Important;//util
//public class Important.Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;//
//            }
//            int left = i + 1;//
//            int right = nums.length - 1;
//            while (left < right) {
//                int tmp = nums[left] + nums[right];
//                if (tmp + nums[i] == 0) {
//                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    left++;
//                    while (left < right && nums[left] == nums[left - 1]) {
//                        left++;
//                    }
//                } else if (tmp +nums[i] < 0) {
//                    left++;
//                } else right--;
//            }
//        }
//        return result;
//    }

//==============================


public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) return null;
            ListNode beforeHead = new ListNode(555);
            ListNode cur = beforeHead;
            while (l1 != null || l2 != null) {
                if(l1 == null) {
                    return l2;
                }
                if(l2 == null) {
                    return l1;
                }
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            return beforeHead.next;
        }


    public static void main(String[] args) {

        //int[] input = {-3, -2, -5, 3, -4, 7, 8, 9};


        ListNode node = new ListNode(0);

        node.next = new ListNode(3);
        node.next.next = new ListNode(6);
        //node.next.next.next = new ListNode(8);
        ListNode anothernode = new ListNode(1);

        anothernode.next = new ListNode(2);
        anothernode.next.next = new ListNode(7);
        //anothernode.next.next.next = new ListNode(15);

        print(node);
        Solution test = new Solution();
        print(test.mergeTwoLists(node, anothernode));
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }

}



