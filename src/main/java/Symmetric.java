public class Symmetric {
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
        System.out.println("-----------------------");
        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        } else if(root1 == null || root2 == null){
            return false;
        }
        return (root1.val==root2.val) && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
}
