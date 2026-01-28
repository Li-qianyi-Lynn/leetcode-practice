    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        
        bounty = [None] * len(nums)
        bounty[0] = nums[0]
        bounty[1] = max(nums[0],nums[1])
        
        for i in range(2,len(nums)):
            bounty[i] = max(bounty[i-2]+nums[i], bounty[i-1])
        
        return max(bounty)