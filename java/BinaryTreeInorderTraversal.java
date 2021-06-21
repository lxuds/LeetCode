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
// Approach 1  Recursion, traversal
// Time complexity: O(n)
// Space complexity: The worst case space required is O(n), and in the average case it is O(long n) where n is the number of nodes. 

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    
    public void helper(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        
        if (root.left != null){
            helper(root.left, res);
        }
        
        res.add(root.val);
        
        if (root.right != null){
            helper(root.right, res);
        }
    }
    
}

// Approach 2 Stack
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}


// Approach 3: Morris Traversal
