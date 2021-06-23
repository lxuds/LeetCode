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
// Approach 1 DFS, recursion
// Time complexity: O(n). need to visity each node exactly once. 
// Space complexity: Worst case, for a completely unbalanced tree, O(n). For a completely balanced tree, O(longn)
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
	    return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


// Approach 2 BFS, iteration
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        int depth = 0;
        TreeNode node;
        q.add(root);
        
        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                node = q.poll();
                if (node.left != null){
                    q.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                }
            }
        }
        return depth;
    }
}


