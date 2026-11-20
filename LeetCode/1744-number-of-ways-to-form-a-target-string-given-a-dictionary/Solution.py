class Solution:
    def numWays(self, words: list[str], target: str) -> int:
        # idx []
        # i: target j: 26 chars
        # dp[i][j]: 在j 之前凑到i 的可能性
        '''
        idx = 0
        0: a1 b1 c1
        1: c1 a1 b1
        2: c2 b1
        3: a2 b1
        count[k][char] = char 出现的次数
        
        '''
        '''
        0 1 2 3 456789...26
        0 1 2 3 456789...26
        0 1 2 3 456789...26
        0 1 2 3 456789...26

        '''


        MOD = 10**9 + 7
        m = len(target)
        n = len(words[0])
        count =[[0] * 26 for _ in range(n)]

        for word in words:
            for j,char in enumerate(word):
                count[j][ord(char)-ord("a")] += 1

        dp =[[0] * (n+1) for _ in range(m+1)]
      
        for j in range(n+1):
            dp[0][j] = 1
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                skip = dp[i][j-1] 
                fre = count[j-1][ord(target[i-1]) - ord("a")] #todo 使用j-1列匹配target i-1
                take = dp[i-1][j-1] * fre % MOD

                dp[i][j] = (skip + take) % MOD
        
        return dp[m][n]


        





    
        