public class SearchBST {

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

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null ||  val == root.val){
            return root;
        }
        TreeNode leftSubtree = searchBST(root.left,val);
        TreeNode rightSubtree = searchBST(root.right,val);
        return leftSubtree != null ? leftSubtree : rightSubtree;
    }
}
