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
// Approach 1: DFS inorder traversal 
// Time complexity: O(N), required to visit each nodes in the tree. The get(index) method is a constant time, O(1) , operation.
// Space complexity: O(N) to store all the nodes  in the tree. 
class Solution {
    List <Integer> sortedNodes;

    public int kthSmallest(TreeNode root, int k) {
        sortedNodes = new ArrayList<>();
        inOrderTraverse(root);
        if (k <= sortedNodes.size()){
            return sortedNodes.get(k-1);
        } else{
            return -1;          
        }
    }
    
    public void inOrderTraverse(TreeNode root){
        if (root == null){
            return;
        }
        inOrderTraverse(root.left);
        sortedNodes.add(root.val);
        inOrderTraverse(root.right);        
    }
}

// Approach 1 but don't use a global variable
class Solution {


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedNodes = new ArrayList<>();
        inOrderTraverse(root, sortedNodes);
        if (k <= sortedNodes.size()){
            return sortedNodes.get(k-1);
        } else{
            return -1;          
        }
    }
    
    public void inOrderTraverse(TreeNode root, List<Integer> arr){
        if (root == null){
            return ;
        }
        inOrderTraverse(root.left, arr);
        arr.add(root.val);
        inOrderTraverse(root.right, arr);     
    }
}


// Approach 2: iterator with stack 
// Time complexity: O(H+k)
// Space complexity: O(H). worst case O(N); well balanced tree O(logN)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true){
            while (cur != null || !stack.isEmpty()){
                while (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                //res.add(cur.val);
                if (--k == 0) {
                    return cur.val;
                }
                cur = cur.right;
            }

        }
    }
}

