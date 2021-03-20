import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/k-distance-from-root/1/?company[]=Amazon&company[]=Amazon&problemType=functional&page=1&category[]=Tree&query=company[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Tree
public class KDistanceFromRoot {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public void display() {
    }

    ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        if (k == 0) {
            list.add(root.data);
            return list;
        }

        list.addAll(Kdistance(root.left,k-1));
        list.addAll(Kdistance(root.right,k-1));

        return list;
    }
}
