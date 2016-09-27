package mianjing;

/**
 * Created by yuliu on 9/27/16.
 */
/*Just breadth-first traverse the tree, keep all node in a array or list.
Then swap the 0 node from the head of the list and non 0 node from the end of the list:

public class ZeroSinkBST {
    public static void zeroSink(BNode node){
        if (node != null){
            List<BNode> list = new ArrayList<BNode>();
            list.add(node);
            BNode p = node;
            int index = 0;
            while (p != null && index < list.size()){
                p = list.get(index);
                if (p.left != null) list.add(p.left);
                if (p.right != null) list.add(p.right);
                index++;
            }
            int start = 0;
            int end = list.size() - 1;
            BNode n1 = list.get(start);
            BNode n2 = list.get(end);
            while (start < end){
                while (n1.data > 0 && start < end) {
                    start++;
                    n1 = list.get(start);
                }
                while (n2.data == 0 && start < end) {
                    end--;
                    n2 = list.get(end);
                }
                n1.data = n2.data;
                n2.data = 0;
            }
        }
}

--------------------
postOrder(BT r) {
  if(r==null)
    return;

  postOrder(r.left);
  postOrder(r.right);

  if(r.val == 0) {
    if(r.left.val != 0) {
       swap(r.val, r.left.val);
    } else {
       swap(r.right, r.right.val);
    }
  }

*/
