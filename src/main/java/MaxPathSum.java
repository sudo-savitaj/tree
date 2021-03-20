public class MaxPathSum {
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

    class Answer{
        int ans=0;
    }

    int maxPathSum(Node root) {
        Answer ans = new Answer();
        maxPathSum(root,ans);
        return ans.ans;
    }

    private int maxPathSum(Node root, Answer ans) {
        if(root == null) return 0;

        int leftMax = Integer.max(maxPathSum(root.left,ans),0);
        int rightMax = Integer.max(maxPathSum(root.right,ans),0);

        int maxSumForIncludingOneSide = root.data + Integer.max(leftMax, rightMax);
        int maxSumIncludingBothNodes = root.data + leftMax + rightMax;
        int maxPath = Integer.max(maxSumForIncludingOneSide, maxSumIncludingBothNodes);
        if (ans.ans < maxPath)
            ans.ans = maxPath;
        return maxSumForIncludingOneSide;
    }
}
