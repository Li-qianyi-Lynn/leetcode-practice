class Solution:
    def jump(self, nums: list[int]) -> int:
        n = len(nums)
        if n <= 1:
            return 0
        
        steps = 0
        end = 0       # 当前这一跳能到达的最远边界
        farthest = 0  # 下一步能到达的最远位置
        
        # 遍历到 n - 1 即可，因为在到达终点前就能确定是否跳跃
        for i in range(n):
            farthest = max(farthest, i + nums[i])
            
            # 到达当前跳跃的边界，必须触发一次新的跳跃
            if i == end:
                steps += 1
                end = farthest
                
                # 如果当前边界已经覆盖终点，提前返回
                if farthest >= n - 1:
                    return steps
                    
        return -1