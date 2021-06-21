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
// Time complexity: O(N)  is required to initiate the constructor for the iterator. 
// next() takes O(1); hasNext() takes O(1)
// Space complexity: O(N), since a new arraylist is created for the sorted nodes. 
// Stack for the inorder traversal worst case is O(N), for a well balanced BST, the height is logN 

class BSTIterator {
    ArrayList<Integer> nodesSorted;
    int index;
    
    public BSTIterator(TreeNode root) {
        nodesSorted = new ArrayList<>();
        index = -1;
        inorder(root);
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        nodesSorted.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        index++;
        return nodesSorted.get(index);
    }
    
    public boolean hasNext() {
        return index + 1 < nodesSorted.size();  
    }
}

