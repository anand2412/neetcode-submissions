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

    public String subRootHash;
    boolean isFound;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        subRootHash = computeHash(subRoot);
        computeAndCheck(root, subRoot);
        return isFound;
    }

    public String computeHash(TreeNode root) {
        if (root == null) return "#";
        String left = computeHash(root.left);
        String right = computeHash(root.right);

        return "("+left + root.val + right+")";
    }

    public String computeAndCheck(TreeNode root, TreeNode subRoot) {
        if(root == null) return "#";
        String left = computeAndCheck(root.left, subRoot);
        String right = computeAndCheck(root.right, subRoot);

        String parentHash = "(" + left + root.val + right + ")";

        if(parentHash.equals(subRootHash)) {
            if(isSameTree(root, subRoot)) {
                isFound = true;
            }
        }

        return parentHash;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return true;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
