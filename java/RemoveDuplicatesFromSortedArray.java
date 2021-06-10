// time complexity: O(n)
// space complexity: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int fast = 0;
        int slow = 0; 
        nums[slow] = nums[fast]; 
        for (fast = 1; fast < nums.length; fast++){
            if (nums[fast] != nums[fast - 1]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
