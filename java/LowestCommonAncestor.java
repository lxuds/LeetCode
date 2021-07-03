// Approach 1: To find the lowest common ancestor, we need to find where is p and q and a way to track their ancestors. 
// A parent pointer for each node found is good for the job. After we found both p and q, we create a set of p's ancestors. 
// Then we travel through q's ancestors, the first one appears in p's is our answer.
// Time complexity: O(N)
// Space complexity: O(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}


// Approach 2:  run DFS for both p and q values and create paths from root to p and q. These paths can be stored in lists. Since we need lowest common ancestor, we can check from the front for the last such node which is common in both the lists.
// Time Complexity: DFS will lead to O(N) since this is a binary tree and not a binary search tree.
//Two DFS operations will lead to O(N). Comparison work of the lists - using a while loop - to find common element will take O(N)
// So total running time - O(N)
// Space Complexity: Lists to store paths can lead to O(N)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        
        findNode(root, p.val, pathP);
        findNode(root, q.val, pathQ);
        int i = 0;
        while (i < pathP.size() && i < pathQ.size() && pathP.get(i).val == pathQ.get(i).val){
            i++;
        }
        return pathP.get(i-1);
        
    }
    
    
    public static Boolean findNode(TreeNode root, int nodeVal, List<TreeNode> path){
        if (root == null){
            return false;
        }
        path.add(root);
      
        if (root.val == nodeVal){
            return true;
        }
        if (findNode(root.left, nodeVal, path) || findNode(root.right, nodeVal, path))
        {
            return true;
        }
        
        path.remove(path.size()-1);
        return false;
      
    }
}


// Approach 3:

