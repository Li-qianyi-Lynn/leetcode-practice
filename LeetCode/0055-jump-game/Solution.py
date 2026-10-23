class Solution:
    def canJump(self, nums: list[int]) -> bool:
        max_reach = 0
        n = len(nums)
        
        for i, jump in enumerate(nums):
            # 如果当前位置已经超出了能跳到的最远范围，说明卡住了
            if i > max_reach:
                return False
            
            # 更新能到达的最远位置
            max_reach = max(max_reach, i + jump)
            
            # 提前剪枝：已经可以到达或超过终点
            if max_reach >= n - 1:
                return True
                
        return True