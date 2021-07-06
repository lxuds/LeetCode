/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Approach 1:  DFS, traverse all the tree. 
// Time complexity: O(N)
// Space complexity: O(H), height of the tree. 
class Solution {
    
    boolean findP = false;
    boolean findQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode res = dfs(root, p, q);
        if (findP && findQ){
            return res;
        } else {
            return null;
        }
    }        
        
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (root == p){
            findP = true;
            return root;
        } 
        if (root == q){
            findQ = true;
            return root;
        }
        
        if (left != null && right != null){
            return root;
        } else {
            return left == null ? right : left;
        }
    }    

}


// Approach 2: Use parent pointer 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();        
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> ancestor = new HashSet<>();

        parent.put(root, null);
        stack.push(root);
        
        
        while ((!parent.containsKey(p) || !parent.containsKey(q)) && !stack.isEmpty()){
            TreeNode node = stack.pop();            
            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        if (!parent.containsKey(p) || !parent.containsKey(q)){
            return null;
        }
        
        while (p != null){
            ancestor.add(p);
            p = parent.get(p);
        }
        
        while (!ancestor.contains(q)){
            q = parent.get(q);
        }
        return q;
        
    }
}
