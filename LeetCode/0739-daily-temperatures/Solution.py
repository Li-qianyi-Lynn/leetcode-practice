class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        """
        stack [] idx
        dic{} tem -> days

        while stack and tem > stack[-1]:
            calculate days
        """
        stack = []
        # tem_dic = {}
        n = len(temperatures)
        res = [0] * n

        for i in range(n):
            cur_temp = temperatures[i]
            # while stack and tem > stack[-1]: calculate days
            while stack and cur_temp > temperatures[stack[-1]]:
                prev_day = stack.pop()
                days = i - prev_day
                # tem_dic[prev_day] = days
                res[prev_day] = days

            stack.append(i)
        return res
    


