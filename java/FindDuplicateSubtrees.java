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
// Time complexity: O(N^2)
// Space complexity: O(N^2)
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> subtreeCount = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        postorder(root, subtreeCount, res);
        return res;
        
    }
    
    public String postorder(TreeNode root, Map<String, Integer> subtreeCount, List<TreeNode> res){
        if (root == null){
            return "#";
        }
        String subtree = root.val + "," + postorder(root.left, subtreeCount, res) + "," + postorder(root.right, subtreeCount, res);

        subtreeCount.put(subtree, subtreeCount.getOrDefault(subtree, 0) + 1);
        if (subtreeCount.get(subtree) == 2){
            res.add(root);
        }
        return subtree;
    }
}
