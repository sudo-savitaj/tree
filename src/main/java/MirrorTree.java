import org.w3c.dom.Node;
//https://practice.geeksforgeeks.org/problems/mirror-tree/1/?company[]=Amazon&company[]=Amazon&problemType=functional&page=1&category[]=Tree&query=company[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Tree
public class MirrorTree {
    class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public void display() {
    }

    void mirror(Node node)
    {
        if(node == null) return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirror(node.left);
        mirror(node.right);
    }
}
