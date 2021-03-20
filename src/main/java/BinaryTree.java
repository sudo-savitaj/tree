import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
        TreeNode root = new TreeNode(5);
        List<Integer> list1 = preorderTraversal(root);
        System.out.println("-----------------------");
        for (Integer item : list1) {
            System.out.println(item);
        }

        List<Integer> list2 = inorderTraversal(root);
        System.out.println("-----------------------");
        for (Integer item : list2) {
            System.out.println(item);
        }

        List<Integer> list3 = postorderTraversal(root);
        System.out.println("-----------------------");
        for (Integer item : list3) {
            System.out.println(item);
        }

        List<List<Integer>> list4 = levelOrder(root);
        System.out.println("-----------------------");
        for (List<Integer> list : list4) {
            for (Integer item : list) {
                System.out.println(item);
            }
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if (root == null) {
            return pre;
        }
        pre.add(root.val);
        pre.addAll(preorderTraversal(root.left));
        pre.addAll(preorderTraversal(root.right));
        return pre;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        if (root == null) {
            return in;
        }
        in.addAll(inorderTraversal(root.left));
        in.add(root.val);
        in.addAll(inorderTraversal(root.right));
        return in;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        if (root == null) {
            return in;
        }
        in.addAll(inorderTraversal(root.left));
        in.addAll(inorderTraversal(root.right));
        in.add(root.val);
        return in;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> in = new ArrayList<>();
        if(root == null){
            return in;
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            int count = levelQueue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = levelQueue.remove();
                list.add(node.val);
                if(node.left != null) {
                    levelQueue.add(node.left);
                }
                if(node.right != null) {
                    levelQueue.add(node.right);
                }
                count--;
            }
            in.add(list);
        }

        return in;
    }
}
