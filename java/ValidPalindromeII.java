// time complexity: O(n)
// space complexity: O(1)
class Solution {
    public boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--){
            if (s.charAt(left) != s.charAt(right)){
                return (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right-1));
            }
        }
        return true;
    }


    private boolean isPalindrome(String s, int left, int right){
        for (int l = left, r = right; l < r; l++, r--){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
        }
        return true;
    }
}

