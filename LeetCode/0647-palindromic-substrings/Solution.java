class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        // find mid point
        for (int i = 0; i < n; i++) {
            res += expand(s,i,i);
            res += expand(s,i,i+1);

        }
        return res;


        
    }
    // find how many palindromes
    private int expand(String s, int l, int r) {
        int count = 0;
        
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count ++;
            l--;
            r++;
        }
       
        return count;
    }
}
/**

odd
even
find mid point
isPalindromic?
yes -count

res = odd + even

 */