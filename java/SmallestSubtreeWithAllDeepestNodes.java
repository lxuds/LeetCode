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

// Time complexity: O(N);
// Space complexity: worst case O(N), skewed trees. Completely balanced tree log(N)
class Solution {
    TreeNode res = null;
    int deepestLevel = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;        
    }
    
    public int dfs(TreeNode root, int level){
        if (root == null) return level;
        
        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);
        int curLevel = Math.max(leftLevel, rightLevel);
        deepestLevel = Math.max(curLevel, deepestLevel);
        if (leftLevel == deepestLevel && rightLevel == deepestLevel){
            res = root;
        }
        return curLevel;
    }
}
