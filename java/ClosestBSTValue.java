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


// Approach 1
// Time complexity: O(H)
// Space complexity: O(1)
class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null){
            if(Math.abs(root.val - target) < Math.abs(res - target)){
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;    
    }
}


// Approach 2: Iterative Inorder with stack
// Time complexity: O(k) in the average case, worst case O(H+k) (O(N+k))
// Space complexity: O(H)

class Solution {
  public int closestValue(TreeNode root, double target) {
    LinkedList<TreeNode> stack = new LinkedList();
    long pred = Long.MIN_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();

      if (pred <= target && target < root.val)
        return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;

      pred = root.val;
      root = root.right;
    }
    return (int)pred;
  }
}
