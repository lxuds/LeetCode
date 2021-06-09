//Method 1:
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

//Method 2: 
    // time complexity: O(n)
    // space complexity: O(1)
    // do not use java character's built-in methods. two pointers. 
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<Character> characterList = new ArrayList<>();
        int aAGap = 'a' - 'A';
        
        for (char c : chars){
            if (c < '0' || (c > '9' && c < 'A') || (c > 'Z' && c < 'a') || c > 'z'){
                continue;
            }
            if (c > 'Z'){
                c -= aAGap;
            }
            characterList.add(c);
        }
        
        for (int left = 0, right = characterList.size() - 1; left < right; left++, right--){
            if (characterList.get(left) != characterList.get(right)){
                return false;
            }
        }
        return true;
