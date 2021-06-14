// Time Complexity: O(H), where H is a tree height. 
// That results in O(log N) in the average case, and O(N) in the worst case. 
// Space Complexity: O(H) to keep the recursion stack, i.e. O(logN) in the average case, and O(N) is the worst case. 

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){ 
            return new TreeNode(val);
        }
        if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
