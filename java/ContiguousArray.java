// time complexity: O(n)
// space complexity: O(n)
    public int findMaxLength(int[] nums) {      
        int maxLen = 0; 
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>(); 
        map.put(0,-1); //init physical meaning: when key = 0;  
        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int key = i+1 - 2 * prefixSum; // the number of 0s left after taking asway the same number of 0s as 1s.  
            if (map.containsKey(key)){
                maxLen = Math.max(i - map.get(key), maxLen);
            } else{ // else means keep the leftmost index for the current key 
                map.put(key, i);
            }
        }
        return maxLen;
    }

