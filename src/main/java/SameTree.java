import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SameTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public void display() {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q == null) return true;
        if (p==null || q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSameTreeNonRecursion(TreeNode p, TreeNode q) {
         if(p== null && q == null ) return true;
        ArrayDeque<TreeNode> pQueue =  new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> qQueue = new ArrayDeque<TreeNode>();
        if(p!=null) pQueue.addFirst(p);
        if(q!=null) qQueue.addFirst(q);
        while (!pQueue.isEmpty() &&!qQueue.isEmpty()){
            p = pQueue.removeFirst();
            q = qQueue.removeFirst();
            if(p.val != q.val) return false;
            if(p.left!= null && q.left != null)
            {
                pQueue.addLast(p.left);
                qQueue.addLast(q.left);
            } else if(p.left!= null || q.left != null) return false;

            if(p.right!= null && q.right != null)
            {
            pQueue.addLast(p.right);
            qQueue.addLast(q.right);
            } else if(p.right!= null || q.right != null) return false;

        }

        if(!pQueue.isEmpty() || !qQueue.isEmpty()) return false;
        return true;
    }
}
