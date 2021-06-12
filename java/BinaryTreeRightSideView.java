// Time complexity: O(n)
// Space complexity: O(D); D is a tree diameter
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);                    
                }
                if (i == size - 1){
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
