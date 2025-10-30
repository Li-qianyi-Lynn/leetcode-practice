class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l = r = 0
        
        while r < len(nums):
            
            while r + 1 < len(nums) and nums[r+1] == nums[r]:
                r += 1
                
            nums[l] = nums[r]
            l += 1
            r += 1
            
        return l