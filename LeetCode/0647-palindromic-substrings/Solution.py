class Solution:
    def countSubstrings(self, s: str) -> int:
        res = 0
        n = len(s)
        # helper expand: count substrings
        def expand(l,r): # count
            count = 0
            while l>= 0 and r < n and s[l] == s[r]:
                count+=1
                l-=1
                r+=1
            return count


        # for loop to get the idx: odd even
        for i in range(n):
            res += expand(i,i)
            res += expand(i,i+1)
        return res

        
        