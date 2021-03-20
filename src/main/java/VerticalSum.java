//https://practice.geeksforgeeks.org/problems/vertical-sum/1/?category[]=Tree&category[]=Tree&company[]=Amazon&company[]=Amazon&problemType=functional&page=1&query=category[]Treecompany[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Tree
import java.util.ArrayList;
import java.util.HashMap;

public class VerticalSum {

    class Node{
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

    public ArrayList<Integer> verticalSum(Node root) {
        HashMap<Integer, Integer> sumforEachVertical = new HashMap<>();
        verticalSum(root,0,sumforEachVertical);
        if(!sumforEachVertical.isEmpty())
            return new ArrayList<>(sumforEachVertical.values());
        return null;
    }

    private void verticalSum(Node root, int horizontalDistance, HashMap<Integer, Integer> sumforEachVertical) {
        if(root == null) return;

       int prevSum = sumforEachVertical.containsKey(horizontalDistance) ? sumforEachVertical.get(horizontalDistance) : 0;
       sumforEachVertical.put(horizontalDistance,prevSum+root.data);

       verticalSum(root.left,horizontalDistance-1,sumforEachVertical);
       verticalSum(root.right,horizontalDistance+1,sumforEachVertical);
    }
}
