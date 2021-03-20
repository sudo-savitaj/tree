//https://practice.geeksforgeeks.org/problems/check-if-subtree/1/?company[]=Amazon&company[]=Amazon&problemType=functional&page=2&category[]=Tree&query=company[]AmazonproblemTypefunctionalpage2company[]Amazoncategory[]Tree#
public class CheckIfSubtree {
    class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=null;
            right=null;
        }
    }
    public static boolean isSubtreeOp(Node T, Node S) {
        // add code here.
        return isSubtree(T,S,false);
    }

    private static boolean isSubtree(Node t, Node s, boolean started) {
        if(s== null) return true;
        if(t==null) return false;

        if(!started)

        if(started) return t.data == s.data && isSubtree(t.left,s.left,started) && isSubtree(t.right,s.right,started);

        if(t.data == s.data) return isSubtree(t.left,s.left,true) && isSubtree(t.right,s.right,true);

        return isSubtree(t.left,s,started)||isSubtree(t.right,s,started);
    }

    boolean areIdentical(Node root1, Node root2)
    {

        /* base cases */
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
        return (root1.data == root2.data
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Node T, Node S)
    {
        /* base cases */
        if (S == null)
            return true;

        if (T == null)
            return false;

        /* Check the tree with root as current node */
        if (areIdentical(T, S))
            return true;

        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(T.left, S)
                || isSubtree(T.right, S);
    }


//    // A utility function to store inorder traversal of tree rooted
//    // with root in an array arr[]. Note that i is passed as reference
//    void storeInorder(Node node, char arr[], Passing i)
//    {
//        if (node == null) {
//            arr[i.i++] = '$';
//            return;
//        }
//        storeInorder(node.left, arr, i);
//        arr[i.i++] = node.data;
//        storeInorder(node.right, arr, i);
//    }
//
//    // A utility function to store preorder traversal of tree rooted
//    // with root in an array arr[]. Note that i is passed as reference
//    void storePreOrder(Node node, char arr[], Passing i)
//    {
//        if (node == null) {
//            arr[i.i++] = '$';
//            return;
//        }
//        arr[i.i++] = node.data;
//        storePreOrder(node.left, arr, i);
//        storePreOrder(node.right, arr, i);
//    }
//
//    /* This function returns true if S is a subtree of T, otherwise false */
//    boolean isSubtree(Node T, Node S)
//    {
//        /* base cases */
//        if (S == null) {
//            return true;
//        }
//        if (T == null) {
//            return false;
//        }
//
//        // Store Inorder traversals of T and S in inT[0..m-1]
//        // and inS[0..n-1] respectively
//        char inT[] = new char[100];
//        String op1 = String.valueOf(inT);
//        char inS[] = new char[100];
//        String op2 = String.valueOf(inS);
//        storeInorder(T, inT, p);
//        storeInorder(S, inS, p);
//        inT[p.m] = '\0';
//        inS[p.m] = '\0';
//
//        // If inS[] is not a substring of preS[], return false
//        if (strstr(op1, op2) != null) {
//            return false;
//        }
//
//        // Store Preorder traversals of T and S in inT[0..m-1]
//        // and inS[0..n-1] respectively
//        p.m = 0;
//        p.n = 0;
//        char preT[] = new char[100];
//        char preS[] = new char[100];
//        String op3 = String.valueOf(preT);
//        String op4 = String.valueOf(preS);
//        storePreOrder(T, preT, p);
//        storePreOrder(S, preS, p);
//        preT[p.m] = '\0';
//        preS[p.n] = '\0';
//
//        // If inS[] is not a substring of preS[], return false
//        // Else return true
//        return (strstr(op3, op4) != null);
//    }

}
