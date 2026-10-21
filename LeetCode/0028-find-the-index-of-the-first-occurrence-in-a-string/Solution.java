class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n > m) {
            return -1;
        }
  

        for (int i = 0; i < m-n+1; i++) {
            int j = 0;
            while (i < m && j < n && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
                if (j == n) {
                    return i;
                }
            }

        }
        return -1;
        
    }
}/**
sliding window

 sadbutsad
 i
    

 sad
 j
 
 */