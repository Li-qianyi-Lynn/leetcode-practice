class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        if n <= 1:
            return n
        
        slide_win = {}
        l = 0
        res = 0
        for r in range(n):
            c = s[r]
            if c in slide_win and slide_win[c] >= l:
                l = slide_win[c] +1
            
            slide_win[c] = r
            res = max(res, r-l+1)
        return res
            

        