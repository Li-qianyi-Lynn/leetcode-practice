1class Solution:
2    def longestPalindrome(self, s: str) -> str:
3        def expand(i,j):
4            left = i
5            right = j
6
7            while left >= 0 and right < len(s) and s[left] == s[right]:
8                left -=1
9                right +=1
10            
11            return right - left -1
12
13        ans = [0,0]
14
15        for i in range(len(s)):
16            odd_len = expand(i,i)
17            even_len = expand(i, i+1)
18            if (odd_len) > ans[1] - ans[0] +1:
19                dist = odd_len // 2
20                ans = [i-dist, i+ dist]
21            if (even_len) > ans[1] - ans[0] +1:
22                dist = (even_len -1) // 2
23                ans = [i-dist, i+ dist+1]
24
25        i,j = ans
26        return s[i: j+1]
27        