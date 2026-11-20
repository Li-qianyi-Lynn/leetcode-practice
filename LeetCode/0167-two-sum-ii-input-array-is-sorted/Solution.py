class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        res = []
        n = len(numbers)
        l = 0
        r = n-1
        while l < r:
            if numbers[l] + numbers[r] == target:
                res.append(l+1)
                res.append(r+1)
                break
            
            elif numbers[l] + numbers[r] < target:
                l += 1
            else:
                r -= 1
        
        return res
        