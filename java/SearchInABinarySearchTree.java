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

// Approach 1: recursion  
// Time Complexity: O(H). In worst case, a skewed tree, O(N); For a well balanced tree, O(logN)
// Space Complexity: O(H) to keep the recursion stack, i.e. O(logN) in the average case, and O(N) in the worst case.

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null || root.val == val) return root;
        return val < root.val? searchBST(root.left, val): searchBST(root.right, val);   // a direct return outside if/else statement
    }
}

// Approach 2:  Iteration
// Time complexity: O(H). H is the tree height. O(logN) in the average case. O(N) in the worst case. 
// Space complexity: O(1)


class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    while (root != null && val != root.val)
      root = val < root.val ? root.left : root.right;
    return root;
  }
}



