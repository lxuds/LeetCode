// time complexity: O(n)
// space complexity: O(n)
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)){
                total += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        }
    
        return total;   
    }
