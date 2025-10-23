class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) {return;}
        int last = m + n -1;

        // compare the last element in each int array, merge the bigger one to the nums1 last.

        while (m > 0 && n> 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[last] = nums1[m-1];
                m--;

            } else {
                nums1[last] = nums2[n-1];
                n--;
            }
            last--;

        }
       // while all elements in nums2 are smaller than those in nums1
        while (n > 0) {
            nums1[last] = nums2[n-1];
            n--;
            last--;
        }   
    }
}