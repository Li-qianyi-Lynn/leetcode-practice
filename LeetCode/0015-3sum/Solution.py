class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        res = []
        # dedup

        # step1 sort
        nums.sort()
        n = len(nums)
        #step2 for loop nums nums[i] [-4,-1,-1,0,1,2,]
        for i in range(n):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i-1]:
                continue
        #step2.1 l,r
            l,r = i+1, n-1
            while l < r:
                cur_sum = nums[i] + nums[l] + nums[r]
            # sum == 0 update res[] -> move l, r 
                if cur_sum == 0:
                    res.append([nums[i],nums[l],nums[r]])
                    l+=1
                    r-=1
                    while l < r and nums[l] == nums[l-1]:
                        l+=1
                    
                    while l < r and nums[r] == nums[r+1]:
                        r-=1
            # sum < 0 move l
                elif cur_sum < 0:
                    l+=1

            # sum > 0 move r 
                else:
                    r-=1
        
        return res

        