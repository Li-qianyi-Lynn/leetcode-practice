1class Solution:
2    def twoSum(self, nums: list[int], target: int) -> list[int]:
3        seen = {}
4        for i, num in enumerate(nums):
5            if target - num in seen:
6                return [seen[target - num], i]
7            seen[num] = i
8            
9
10
11        