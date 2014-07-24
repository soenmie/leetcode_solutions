/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum (TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return 0;
        }

        sumLinkToAnc(root);

        return max;
    }

    private int sumLinkToAnc (TreeNode node) {
        if (node.left == null && node.right == null) {
            max = (node.val > max) ? node.val : max;
            return node.val;
        }

        int leftSum = 0;
        int rightSum = 0;

        if (node.left != null) {
            leftSum = sumLinkToAnc(node.left);
        }
        if (node.right != null) {
            rightSum = sumLinkToAnc(node.right);
        }

        if (leftSum < 0) {
            leftSum = 0;
        }

        if (rightSum < 0) {
            rightSum = 0;
        }

        int sum = leftSum + rightSum + node.val;

        max = (sum > max) ? sum : max;

        int maxChild = Math.max(leftSum, rightSum);

        if (maxChild < 0) {
            maxChild = 0;
        }

        return node.val + maxChild;
    }

    private int max = -Integer.MAX_VALUE;
}