// Time complexity: O(n), iteration of i, and j+k = n/2
// Space complexity: depending on sorting. for quick sort, worst case O(logn) 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List <List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums); // nlogn(n)
        // assume nums[i] is the smallest number among these three numbers 
        for (int i = 0; i < nums.length && nums[i] <= 0; i++){
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            twoSumII(nums, i, res);
        }
        return res;
    }
    
    public void twoSumII(int[] nums, int i, List <List<Integer>>res){
        int left = i + 1; // avoid duplicate 
        int right = nums.length - 1;
        
        while(left < right){
            int sum = nums[left] + nums[right] + nums[i];
            if (sum == 0){
                res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (nums[left] == nums[left - 1] && left < right){ // deleting this sentence res will have duplicates.
                    left++;                    
                }
            } else if (sum > 0){
                while (nums[right] == nums[right - 1] && left < right){
                    right--;
                }
                right--;

            } else {
                while (left < right && nums[left] == nums[left + 1]){
                    left++;                    
                }
                left++;                    
            }
        }
        return;
    }

}
