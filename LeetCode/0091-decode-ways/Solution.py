class Solution:
    def numDecodings(self, s: str) -> int:
        #return the number of ways to decode it.
        # s start with 0 ->  invalid
        n = len(s)
        if s[0] == "0":
            return 0
       
        if n == 1 and int(s) != 0:
            return 1

        dp = [0 for i in range(n+1)]
        dp[0] = 1
        dp[1] = 1

        for i in range(2, n+1):
            if s[i-1] != "0":
                dp[i] += dp[i-1]
            
            two_digit = int(s[i-2:i])
            if 10 <= two_digit <= 26:
                dp[i] += dp[i-2]
 
        return dp[n]


    




        