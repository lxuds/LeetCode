// Approach 1
// Time complexity: O(m+n)
// Space complexity: O(1), only create three indices 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n -1;
        int ind2 = n -1;
        int ind1 = m -1;
        
        while (ind2 >=0 && ind1 >= 0){
            if (nums1[ind1] > nums2[ind2]){
                nums1[index] = nums1[ind1];
                index--;
                ind1--;
            } else {
                nums1[index] = nums2[ind2];
                index--;
                ind2--;
            }
        }
        
        // if ind1 >=0, OK. leave the elements in nums1
        // if ind2 >=0, copy these elements in to nums1 
        while (ind2 >= 0){
            nums1[index] = nums2[ind2];
            index--;
            ind2--;
        }
        
    }
}


// Approach 2
// copy nums2 to nums1[n:m-1], and do Arrays.sort(nums1)
// Time complexity: O((n+m)log(n+m)) best, worst O((n+m)^2)
// Space complexity: O(1) Java uses quicksort to sort int arrays. 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}

