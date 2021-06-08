// time complexity: O(n)
// space complexity: O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum >= target ){ // left <= right is not necessary because  
                sum -= nums[left];
                left += 1;
                minLen = Math.min(minLen, right - left + 2);                
            }
        }
        return minLen <= nums.length ? minLen: 0;
    }
