// time complexity: O(n) tranverse the array 
// space complexity: O(n) to store the hash table

    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int key = (prefixSum % k < 0) ?  (prefixSum % k +k): (prefixSum % k); 
            if (map.containsKey(key)){
                count += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;    
    }
