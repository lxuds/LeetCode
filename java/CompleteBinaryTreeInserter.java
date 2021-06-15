// time complexity: The preprocessing is O(N), traverse all treenodes. Each insertion operation thereafter is O(1).
// space complexity: O(Nend), number of end leaves.   
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
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue;
    

    public CBTInserter(TreeNode root) {
        this.root = root;
        
        queue = new LinkedList<>();
        // using BFS to populate queue
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.peek();
            if (node.left == null || node.right == null){
                if (node.left != null){
                    queue.offer(node.left);
                }
                break; // means find the parent node where the new tree node should be insterted. 
            }
            
            // pop this TreeNode if it has both left and right nodes. 
            // Not a node that will be a parent node for a new insterted TreeNode.
            // This TreeNode's two child nodes should be add to the queue             
            queue.poll(); 
            queue.offer(node.left);
            queue.offer(node.right); 
        }
        
    }
    
    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        TreeNode node = queue.peek();
        
        if (node.left != null){
            node.right = newNode;
            queue.poll();
            queue.offer(newNode);
            return node.val;
        } else{
            node.left = newNode;
            queue.offer(newNode);
            return node.val;
        }
        
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
