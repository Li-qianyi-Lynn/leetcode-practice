class Solution:
    def findOrder(self, numCourses: int, prerequisites: list[list[int]]) -> list[int]:
        #bfs
        # map: precourse -> [courses to be unlocked]
        # list: i-course list[i]: num of precourses
        # queue : to process courses, if courses have no prerequists -> add it to the queue and add it to the res list

        res = []
        n = len(prerequisites)
        if n == 0:
            for i in range(numCourses):
                res.append(i)
            return res
        
        predict = defaultdict(list)
        pre_list = [0] * numCourses
        q = deque()
        for pres in prerequisites:
            predict[pres[1]].append(pres[0])
            pre_list[pres[0]]+=1
        
        for i in range(numCourses):
            if pre_list[i] == 0:
                q.append(i)
                res.append(i)
        
        while q:
            cur = q.popleft()
            nex = predict[cur]
            for n in nex:
                pre_list[n]-=1
                if pre_list[n] == 0:
                    q.append(n)
                    res.append(n)
        

        return res if len(res) == numCourses else []


        