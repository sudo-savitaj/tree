import org.w3c.dom.Node;

public class ConnectBinaryTreeToNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public void display() {

    }

    public Node connect(Node root) {
        return connectToNext(root);
    }

    private Node connectToNext(Node root) {
        if(root == null){
            return null;
        }

        Node childNext = null;
        if(root.next!= null){
            childNext = root.next.left != null ? root.next.left : root.next.right;
        }

        if(root.left != null){
            root.left.next = root.right != null ? root.right: childNext;
        }

        if(root.right != null){
            root.right.next = childNext;
        }

        connectToNext(root.left);
        connectToNext(root.right);

        return root;
    }

    private Node connectNextRight(Node root){
        Node dummyHead = new Node(0);
        Node pre = dummyHead;
        Node current = root;

        while (current != null) {
            if (current.left != null) {
                pre.next = current.left;
                pre = pre.next;
            }

            if (current.right != null) {
                pre.next = current.right;
                pre = pre.next;
            }
            current = current.next;
            if (current == null) {
                pre = dummyHead;
                current = dummyHead.next;
                dummyHead.next = null;
            }
        }

        return root;
}
}
