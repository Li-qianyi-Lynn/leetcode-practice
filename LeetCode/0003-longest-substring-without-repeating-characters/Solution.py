class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        #edge case
        if n <= 1:
            return n
        
        window = {}
        l = 0
        res = 0
        for r in range(n):
            c = s[r]
            
       
            if c in window and window[c] >= l:
                l = window[c]+1
    
            window[c] = r  
            res = max(res, r-l+1)

        
        return res   
  



        
"""

abcabcbb 
 l
   r 
res = 1
dict: char -> index
a 3
b 1
c 2
update :max(res,r-l+1)
"""
#"abcabcbb"     