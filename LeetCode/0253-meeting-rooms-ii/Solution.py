import heapq

class Solution:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:
        if not intervals:
            return 0
        
        # 1. 按照会议的起始时间升序排序
        intervals.sort()
        
        # 2. 初始化最小堆，用于存放当前正在进行的会议的结束时间
        min_heap = []
        
        for interval in intervals:
            start, end = interval
            
            # 如果堆不为空，且当前会议的开始时间 >= 堆顶（最早结束的会议时间）
            # 说明有房间空出来了，把原先占用的房间释放（弹出堆顶）
            if min_heap and start >= min_heap[0]:
                heapq.heappop(min_heap)
            
            # 将当前会议的结束时间压入堆中（占用一个房间）
            heapq.heappush(min_heap, end)
            
        # 3. 堆中剩下的元素个数就是所需的最小会议室数量
        return len(min_heap)   