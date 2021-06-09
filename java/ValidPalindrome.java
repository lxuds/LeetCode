// time complexity: O(n)
// space complexity: O(1)
    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() -1; left < right; left++, right--){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
        }
        return true;
    }
