class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        # backtracking
        # l: num of l < n
        # r:  num of r < l
        cur_res = []
        res = []
        def backtracking(cur_res, l_num, r_num):
            #base case
            if len(cur_res) == 2 * n:
                res.append("".join(cur_res))
                return res

            #check left + re
            if l_num < n:
                cur_res.append("(")
                backtracking(cur_res,l_num+1,r_num)
                cur_res.pop()

            #check right 
            if r_num < l_num:
                cur_res.append(")")
                backtracking(cur_res,l_num,r_num+1)
                cur_res.pop()
        
        backtracking(cur_res, 0, 0)
        return res



