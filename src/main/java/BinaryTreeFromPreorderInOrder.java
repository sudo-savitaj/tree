import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromPreorderInOrder {
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
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root =buildTree(preorder,inorder);

        List<Integer> list = inorderTraversal(root);
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder, inorder, 0,inorder.length -1, 0);
    }

    private TreeNode getTree(int[] prorder, int[] inorder, int startIndexInorder, int endIndexInorder, int preOrderStartIndx) {
        if(startIndexInorder > endIndexInorder || preOrderStartIndx > prorder.length - 1){
            return null;
        }
        int rootValue = prorder[preOrderStartIndx];
        TreeNode node = new TreeNode(rootValue);
        int rootIdxInorder = getIndex(inorder,rootValue);
        int lengthOfRootAndLeftSubtree =  rootIdxInorder - startIndexInorder;
        node.left = getTree(prorder,inorder,startIndexInorder,rootIdxInorder-1, preOrderStartIndx + 1);
        node.right = getTree(prorder,inorder,rootIdxInorder +1,endIndexInorder, preOrderStartIndx + 1 + lengthOfRootAndLeftSubtree);
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
