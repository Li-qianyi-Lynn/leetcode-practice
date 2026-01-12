class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        prefix = [0]
        for c in s:
            prefix.append(int(c) + prefix[-1])

        res = min(prefix[-1], len(s) - prefix[-1])
        for i in range(len(s)):
            res = min(
                res, 
                prefix[i+1] + (len(s) - i - 1 - (prefix[-1] - prefix[i+1]))
            )
        return res