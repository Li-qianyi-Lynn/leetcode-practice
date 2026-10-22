class Solution:
    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        q = deque()
        graph = defaultdict(list)
        for u,v,w in times:
            graph[u].append((v,w))
        
        pq = [(0,k)] #time,node
        dist = {} 

        while pq:
            d,u = heapq.heappop(pq)

            if u in dist:
                continue
            dist[u] = d

            for v,w in graph[u]:
                if v not in dist:
                    heapq.heappush(pq, (d+w,v))

        if len(dist) == n:
            return max(dist.values())
        else: 
            return -1


        