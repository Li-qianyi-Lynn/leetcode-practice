class Solution:
    def nextGreaterElements(self, nums: list[int]) -> list[int]:
        stack = []
        n = len(nums)
        res = [-1] * n
        next_greater = {}
        for i in range(2 * n):
            cur_idx = i % n
            while stack and nums[cur_idx] > nums[stack[-1]]:
                prev_idx = stack.pop()
                res[prev_idx] = nums[cur_idx]
            if i < n:
                stack.append(cur_idx)

        return res

        