class Solution:
    def largestRectangleArea(self, heights: list[int]) -> int:
        new_hi = [0] + heights + [0]
        res = 0
        stack = []
        for i,h in enumerate(new_hi):
            while stack and new_hi[stack[-1]] > h:
                cur_h = new_hi[stack.pop()]
                width = i - stack[-1] -1
                res = max(res, width * cur_h)
            stack.append(i)
        
        return res

        