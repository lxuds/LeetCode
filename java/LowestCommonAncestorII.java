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
    // The code will traverse the whole tree, even after finding one node, since the assumption is the other node may be not in the tree.    
    // The search will go down to the leaves. Any node found will be flagged as true. 
    // If we find a node equal to p/q we keep propagating that node to upper levels too, until at some node, its left and right nodes are both not null.
    // One special case,  suppose some node equals to p and a subtree that starts from p node also contains q. 
    // The recursion will return back the result of node q first. And when recursion reaches p node, node p will be returned to upper levels of recursion, and keep propagating that node to upper levels. And node p will be the final node we are looking for. The result from line 39-40 will not be used at all in this case.  The node will be returned at line 43.

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
         // Exit of the recursion. 
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
