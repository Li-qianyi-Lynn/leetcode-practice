class Solution:
    def nextPermutation(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        1. find breakpoint
2.find the first digit that larger than breakpoint
3. reverse 
        """
        n = len(nums)
        i = n-2
        while i >= 0 and nums[i] >= nums[i+1]:
            i -= 1

        if i < 0:
            return nums.reverse()
        
        j = n-1
        while j > i and nums[j] <= nums[i]:
            j -= 1

        nums[j],nums[i] = nums[i],nums[j]

        l = i+1
        r = n-1
        while l < r:
            nums[l],nums[r] = nums[r],nums[l]
            l += 1
            r -= 1

        return nums

        