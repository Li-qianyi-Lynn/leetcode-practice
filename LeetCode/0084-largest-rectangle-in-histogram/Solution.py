class Solution:
    def largestRectangleArea(self, heights: list[int]) -> int:
        #next smaller
        """
        stack = [] idx
        area = (curIdx -prevIdx ) * heights[preIdx]
        
        """
        heights = [0] + heights + [0]
        max_area = 0
        stack = []
        n = len(heights)
        

        for i in range(n):
            while stack and heights[i] < heights[stack[-1]]:
                cur_hi = heights[stack.pop()]
                if not stack:
                    break
                width = i - stack[-1]-1
                max_area = max(max_area,cur_hi * width  )
            stack.append(i)
        return max_area

[2]
5
2
10
