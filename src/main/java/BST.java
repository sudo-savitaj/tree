public class BST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public void display() {

    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }

    private boolean isValid(TreeNode node, Integer minValue, Integer maxValue) {
        if(node == null)
            return true;

        if((minValue !=null && node.val <= minValue) || (maxValue != null && node.val >= maxValue)){
            return false;
        }

        return isValid(node.left,  minValue,node.val) && isValid(node.right, node.val, maxValue);
    }

}
