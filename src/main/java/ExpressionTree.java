//https://practice.geeksforegeeks.org/problems/expression-tree/1/?company[]=Amazon&company[]=Amazon&problemType=functional&page=1&category[]=Tree&query=company[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Tree
public class ExpressionTree {
    class Node
    {
        String data;
        Node left,right;

        Node(String data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public void display() {

    }

    public int evalTree(Node root) {
        if(root == null) return 0;

        int leftAns = evalTree(root.left);
        int rightAns = evalTree(root.right);

        switch (root.data){
            case "+":
                return leftAns+rightAns;
            case "-":
                return leftAns-rightAns;
            case "*":
               return leftAns*rightAns;
            case "/" :
                return leftAns/rightAns;
            default:
                return Integer.parseInt(root.data);
        }
    }
}
