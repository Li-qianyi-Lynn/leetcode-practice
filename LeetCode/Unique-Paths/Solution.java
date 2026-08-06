class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m > n:
            m, n = n, m
        r = [1] * m
        for _ in range(1, n):
            for i in range(1, m):
                r[i] += r[i - 1]
        return r[-1]