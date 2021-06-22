// Time complexity:  O(n) Each of the nn elements is visited at most once
// Space complexity: O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                return new int[] {left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target){
                left++;
            } else {
                right--;
            }
        }
        return null;        
    }
}
