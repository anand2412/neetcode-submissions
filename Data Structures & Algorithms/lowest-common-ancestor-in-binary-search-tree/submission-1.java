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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // Check if one of p or q is smaller and the other is larger
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root; // root is LCA
        }
    
        // If both p and q are smaller than root, search in the left subtree
        else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
    
        // If both p and q are larger than root, search in the right subtree
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
