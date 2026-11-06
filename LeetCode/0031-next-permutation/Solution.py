class Solution:
    def nextPermutation(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        len(nums)
        """
        n = len(nums)
        if n == 1:
            return nums

        # right -> left | 找下降点 ｜ 单点交换
        # 1 5 4 3 1  -》 3 1 1 4 5 -〉 3 5 4 1 1 -》 3 1 1 4 5
     
        i = n - 2
        while i >= 0 and nums[i] >= nums[i+1]:
            i -=1
        if i < 0:
            nums.reverse()
            return nums
        
        j = n-1
        while j >= i and nums[j] <= nums[i]:
            j -=1
        
        nums[i],nums[j] = nums[j],nums[i]
        
        l = i+1
        r = n-1
        while l < r:
            nums[l],nums[r] = nums[r],nums[l]
            l+=1
            r-=1
        
        return nums




