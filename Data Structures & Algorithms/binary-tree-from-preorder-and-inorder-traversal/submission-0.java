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

    int preorderIndex = 0;
    HashMap<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length != preorder.length) {
            return null;
        }
        inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return constructTree(inorder, 0, inorder.length-1, preorder);
    }

    private TreeNode constructTree(int[] inorder, int inStart, int inEnd, int[] preorder) {
       if (inStart > inEnd) {
           return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIndex++]);  // Create node and move pointer
        int rootIndex = inMap.get(root.val);
        root.left = constructTree(inorder, inStart, rootIndex-1, preorder);
        root.right = constructTree(inorder, rootIndex+1, inEnd, preorder);

        return root;

    }
}
