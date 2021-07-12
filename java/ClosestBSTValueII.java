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
 */
// Approach 1: inorder traversal + two pointers.
// Time complexity: O(N) + k
// Space complexity: O(N)

class Solution {
    int counter;
    List<Integer> arr = new ArrayList<>();
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        
        inOrderTraverse(root, arr, target);
        if (target < arr.get(0)){            
            return arr.subList(0, Math.min(k, arr.size()));
        } 
        if (target > arr.get(arr.size()-1)){
            return arr.subList(Math.max(0, arr.size()-k), arr.size());
        }

        // use two pointers to find the k closest elements to the target.     
        int l = 0;
        int r = 0;
        while (counter - l >= 0 && counter + r + 1 < arr.size()){
            if (Math.abs(arr.get(counter - l) - target) < Math.abs(arr.get(counter + 1 + r) - target)){
                res.add(arr.get(counter - l));
                l++;  
                k--;
            } else if (Math.abs(arr.get(counter - l) - target) > Math.abs(arr.get(counter + 1 + r) - target)){ 
                res.add(arr.get(counter + 1 + r));
                r++;
                k--;
            } else {
                res.add(arr.get(counter + 1 + r));
                res.add(arr.get(counter - l));
                l++;
                r++;
                k--;
                k--;
            }
            if (k == 0){
                return res;
            }
        }
        
        if (k > 0 && counter - l < 0){
            while(k > 0 && counter + r + 1 < arr.size()){
                res.add(arr.get(counter + 1 + r));
                r++;
                k--;   
                if (k == 0){
                    return res;
                }
            }
        }
        
        if (k > 0 && counter + 1 + r >= arr.size()){
            while (k > 0 && counter - l >= 0){
                res.add(arr.get(counter - l));
                l++;
                k--;
                if (k == 0){
                    return res;
                }
            }
        }    
        return res;
    }
    
    
    
    public void inOrderTraverse(TreeNode root, List<Integer> arr, double target){
        if (root == null){
            return ;
        }
        inOrderTraverse(root.left, arr, target);
        if (arr.size() > 0 && arr.get(arr.size()-1) < target && target <= root.val){
            counter = arr.size()-1;
            // arr is ascending. The target value is between arr[counter] and arr[counter+1]. 
        }
        arr.add(root.val);

        inOrderTraverse(root.right, arr, target);     
    }

}


// Approach 2: two stacks 
// Time complexity: O(logN + k)
// Space complexity: O(H) to store the stack. 

class Solution {  

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        //initiate predecessor and successor stacks
        // Find target, and along the route, push nodes to pred if its value < target, 
        // push nodes to succ if its value >= target
        // pred holds nodes with values descending from the top to the bottom, smaller than target. 
        // The one on the top is closest to the target.
        // Succ holds nodes with values ascending from the top to the bottom, bigger than target. 
        // The one on the top is closest to the target. 
        Stack<TreeNode> succ;
        Stack<TreeNode> pred;        
        succ = new Stack<>();
        pred = new Stack<>();
        TreeNode cur = root;
        while (cur != null){  // use cur != null, push to find the node with value closest to target. 
            if (target < cur.val){
                succ.push(cur);
                cur = cur.left;
            } else{
                pred.push(cur);
                cur = cur.right;
            }
        }
        
        while (k > 0){
            if (pred.isEmpty() && succ.isEmpty()){
                break;
            }
            if (pred.isEmpty()){
                int next = getSuccessor(succ);
                res.add(next);
            } else if (succ.isEmpty()){
                int next = getPredecessor(pred);
                res.add(next);
            } else{       
                TreeNode nodePred = pred.peek();
                TreeNode nodeSucc = succ.peek();
                if (Math.abs(nodePred.val - target) < Math.abs(nodeSucc.val - target)){
                    res.add(getPredecessor(pred));
                } else{
                    res.add(getSuccessor(succ));
                }
            }
            k--;
        
        }
        return res;
        
  }
    
    
    
    public int getPredecessor(Stack<TreeNode> pred) {
        TreeNode popped = pred.pop();
        TreeNode cur = popped.left;
        while (cur != null){
            pred.push(cur);
            cur = cur.right;
        }
        return popped.val;
    }
    
    
    public int getSuccessor(Stack<TreeNode> succ){
        TreeNode popped = succ.pop();
        TreeNode cur = popped.right;
        while (cur != null){
            succ.push(cur);
            cur = cur.left;
        }
        return popped.val;
    }

}

