1class Solution:
2    def largestRectangleArea(self, heights: list[int]) -> int:
3        new_hi =[0] + heights + [0]
4        stack = []
5        max_area = 0
6
7        for i, h in enumerate(new_hi):
8            while stack and new_hi[stack[-1]] > h:
9                cur_hi = new_hi[stack.pop()]
10                width = i- stack[-1] -1
11                max_area = max(max_area, width * cur_hi)
12            stack.append(i)
13
14        return max_area
15        