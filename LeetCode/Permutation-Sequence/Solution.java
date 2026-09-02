class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        num_permu = 1
        for i in range(1, n + 1):
            num_permu *= i
        nums = []
        for i in range(1, n + 1):
            nums.append(i)
        res = ''
        k -= 1
        cur_num = n
        for i in range(n):
            num_permu /= cur_num
            idx = int(k // num_permu)
            res += str(nums[idx])
            nums.pop(idx)
            k %= num_permu
            cur_num -= 1
        return res