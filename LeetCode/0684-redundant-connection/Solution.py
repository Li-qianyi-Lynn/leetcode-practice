class Solution:
    def findRedundantConnection(self, edges: list[list[int]]) -> list[int]:
        #1.init graph 
        graph = defaultdict(list)

        
        def dfs(start,target,visited): #visited: 每条路径存的点
            if start == target:
                return True

            visited.add(start)
            tar_list = graph[start]
            for t in tar_list:
                if t not in visited:
                    if dfs(t,target,visited):
                        return True
            
            return False
   
       #2. for loop edges
            # 2.1 check u,v in graph []
                # if yes dfs -> true -> return u,v
            # 2.2 graph[1],append(2) adj 1:2,3, 2:3
        for u,v in edges:
            if u in graph and v in graph:
                if dfs(u,v,set()):
                    return [u,v]
            graph[u].append(v)
            graph[v].append(u)

        return []



        