import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderPostOrder {
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
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root =buildTree(inorder,postorder);

       List<Integer> list = inorderTraversal(root);
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getTree(inorder, postorder, 0,inorder.length -1, postorder.length-1);
    }

    private TreeNode getTree(int[] inorder, int[] postorder, int startIndexInorder, int endIndexInorder, int endIndexPostorder) {
        if(startIndexInorder > endIndexInorder || endIndexPostorder < 0){
            return null;
        }
        int rootValue = postorder[endIndexPostorder];
        TreeNode node = new TreeNode(rootValue);
        int rootIdxInorder = getIndex(inorder,rootValue);
        int lengthOfRootAndRightSubtree = endIndexInorder - rootIdxInorder + 1;
        node.left = getTree(inorder,postorder,startIndexInorder,rootIdxInorder-1, endIndexPostorder- lengthOfRootAndRightSubtree);
        node.right = getTree(inorder,postorder,rootIdxInorder +1,endIndexInorder, endIndexPostorder-1);
        return node;
    }

    private int getIndex(int[] inorder, int rootValue) {
        int i = 0;
        for (int item : inorder) {
            if(item == rootValue)
            {
                return i;
            }
            i++;
        }
        return -1;
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


}
