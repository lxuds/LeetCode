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
// Approach 1: 
// Time complexity: O(min(N1, N2)) 
// Space complexity: O(min(H1, H2)), where H1 and H2 are the heights of the trees of root1 and root2. 


class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        } else if (root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left) || flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
    }
}
