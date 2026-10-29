class Solution:
    def numDecodings(self, s: str) -> int:
        #return the number of ways to decode it.
        # s start with 0 ->  invalid
        n = len(s)
        if s[0] == "0":
            return 0
       
        if n == 1 and int(s) != 0:
            return 1

        # 1: check 0 -> 1
        # 2: check <= 26 +1
        # dfs: top -> button (output: count) input:i
        
        @lru_cache(None)
        def dfs(i):
           
            # base case
            if i < 0: 
                return 1

            res = 0  
            if s[i] != "0":
                res += dfs(i-1) 

            if i >= 1 and 10 <= int(s[i-1:i+1]) <= 26:
                res += dfs(i-2)
            
            return res 

        return dfs(n-1)


    




        