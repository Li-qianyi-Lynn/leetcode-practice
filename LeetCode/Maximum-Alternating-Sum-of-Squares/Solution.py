1class Solution:
2    def maxAlternatingSum(self, nums: List[int]) -> int:
3        n = len(nums)
4        for i in range(n):
5            nums[i] *= nums[i]
6        nums.sort()
7        k = n//2
8        return sum(nums[k:])-sum(nums[:k])
9
10
11
12        