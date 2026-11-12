class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        # heap [5,6] 
        heap = []
        # check  if len(heap) < k: push
        for num in nums:
            if len(heap) < k:
                heapq.heappush(heap,num)
            else: # else: check 堆顶(t) vs num : t < num pop 
                if heap[0] < num:
                    heapq.heappop(heap)
                    heapq.heappush(heap,num)
        return heap[0]
        