class Solution:
    def eraseOverlapIntervals (self, intervals: List[List[int]]) -> int:
        intervals.sort()
        prev, i, ans = 0, 1, 0
        while (i < len(intervals)):
            if (intervals[i][0] < intervals[prev][1]):
                ans += 1
                if (intervals[i][1] < intervals[prev][1]): prev = i
            else: prev = i
            i += 1
        return ans