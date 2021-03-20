//https://www.geeksforgeeks.org/diagonal-sum-binary-tree/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalSumInBinaryTree {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public void display() {
    }

    public static ArrayList<Integer> diagonalSum(Node root)
    {
        ArrayList<Integer> sumList = new ArrayList<>();

        if(root==null) return sumList;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        int size = queue.size();
        int sum =0;
        while (!queue.isEmpty()){
            Node node = queue.remove();
            size--;

            while(node != null){
                sum += node.data;
                if(node.left!= null) queue.add(node.left);
                node = node.right;

            }

            if(size ==0){
                sumList.add(sum);
                sum=0;
                size = queue.size();
            }
        }
        return sumList;
    }
}
