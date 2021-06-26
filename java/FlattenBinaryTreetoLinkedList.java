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
// Approach 1 Reversed preorder  
// Time complexity: O(N)
// Space complexity: O(N) which is occupied by the recursion stack. The tree could be e.g. left skewed and in that case the longest branch (and hence the number of nodes in the recursion stack) would be N. 
class Solution {
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if (root == null) return; 
        flatten(root.right);
        flatten(root.left);  
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
