// Approach 1: DFS recursion
// Time Complexity: O(N), every node is visited exactly once.
// Space Complexity: O(H): stack to store path. well balanced tree O(logN), worst case, skewed tree O(N)
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
    List<String> res; 
    
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, "");
        return res;
    }
    
    public void dfs(TreeNode root, String path){
        if (root != null){
            if (root.left == null && root.right == null){
                path = path + Integer.toString(root.val);
                res.add(path);
                return;
            }     
                path = path + Integer.toString(root.val) + "->";
                dfs(root.left, path);
                dfs(root.right, path);
        }
    }
}
// Approach 2: DFS recusion but using StringBuilder to record path
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if(root == null) return rst;
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, root);
        return rst;
    }
    
    public void helper(List<String> rst, StringBuilder sb, TreeNode root){
        if(root == null) return;
        int tmp = sb.length();
        if(root.left == null && root.right == null){
            sb.append(root.val);
            rst.add(sb.toString());
            sb.delete(tmp , sb.length());
            return;
        }
        sb.append(root.val + "->");
        helper(rst, sb, root.left);
        helper(rst, sb, root.right);
        sb.delete(tmp , sb.length());
        return;
        
    }
}

