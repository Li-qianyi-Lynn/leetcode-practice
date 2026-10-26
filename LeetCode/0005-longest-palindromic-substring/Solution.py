class Solution:
    def longestPalindrome(self, s: str) -> str:
        # odd even -> get len 
        n = len(s)
        def expand (i,j):
            l = i
            r = j
            while r < n and l >= 0 and s[l] ==s[r]:
                l -= 1
                r += 1
            return l+1, r-1
        start, end = 0,0

        for i in range(n):
            l1,r1 = expand(i,i)
            l2,r2 = expand(i,i+1)

            if r1-l1 > end-start:
                start,end = l1,r1
            if r2-l2 > end -start:
                start,end = l2,r2

        return s[start:end+1]




        