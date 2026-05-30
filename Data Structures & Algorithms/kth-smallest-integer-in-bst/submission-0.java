/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int kthSmallest;

    public int kthSmallest(TreeNode root, int k) {
        int[] count =new int[1];
        inorderTraversal(root, k, count);
        return kthSmallest;
    }

    private void inorderTraversal(TreeNode root, int k, int[] count) {
        if(root == null) return;
        
        inorderTraversal(root.left, k, count);
        count[0]++;

        if(count[0] == k) {
            kthSmallest = root.val;
            return;
        }
        inorderTraversal(root.right, k, count);
    }
}
