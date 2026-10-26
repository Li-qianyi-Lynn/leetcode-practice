class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        dedup = set(nums)
        res = 0
        for num in dedup:
            if num-1 not in dedup:
                ele = 1
                while num+1 in dedup:
                    ele +=1
                    num+=1
                res = max(ele,res)
        return res
                

        