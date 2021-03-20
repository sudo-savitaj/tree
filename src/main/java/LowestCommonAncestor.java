//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1/?category[]=Tree&category[]=Tree&company[]=Amazon&company[]=Amazon&problemType=functional&page=1&query=category[]Treecompany[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Tree
public class LowestCommonAncestor {
    class Node {
        public int data;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            data = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            data = _val;
            left = _left;
            right = _right;
        }
    }

    public void display() {

    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        Node lowestCommonAncestor = lowestCommonAncestor(root.left, p, q);
        if (lowestCommonAncestor != null)
            return lowestCommonAncestor;

        lowestCommonAncestor = lowestCommonAncestor(root.right, p, q);
         if (lowestCommonAncestor != null)
            return lowestCommonAncestor;

      if (containsBoth(root, p, q))
            return root;
        return null;
    }

    private boolean containsBoth(Node root, Node p, Node q) {
        if (contains(root, p) && contains(root, q))
            return true;
        return false;
    }

    private boolean contains(Node root, Node p) {
        if (root == null) {
            return false;
        }
        if (root.data == p.data) {
            return true;
        }
        return contains(root.left, p) || contains(root.right, p);
    }

    Node lca(Node node, int n1, int n2)
    {
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2)
            return lca(node.right, n1, n2);

        return node;
    }

}
