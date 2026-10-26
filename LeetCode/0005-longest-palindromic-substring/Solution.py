class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        max_len = 1
        n = len(s)
        def helper(i,j):
            while i >= 0 and j < n and s[i] == s[j]:
                i-=1
                j+=1
            return s[i+1:j]

        for i in range(n):
        #helper: start from center odd/even. check len []
            odd_res = helper(i,i)
            even_res = helper(i,i+1)

            if len(odd_res) > len(res):
                res = odd_res
            if len(even_res) > len(res):
                res = even_res

        return res

        