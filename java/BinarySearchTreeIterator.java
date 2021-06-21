//Approach 1: Stack
// Time complexity:
// Space complexity:
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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
    }

    
    public int next() {
        TreeNode node = stack.pop();
        TreeNode temp = node.right;
        
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        return node.val;
    }
    
    public boolean hasNext() {
        if (!stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


// Approach 2: recursion

