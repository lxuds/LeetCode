// Hashmap
// Time complexity: O(n)
// Space complexity: O(1)
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)){
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            } 
            if (!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }
            
        return maxLength;
    }
