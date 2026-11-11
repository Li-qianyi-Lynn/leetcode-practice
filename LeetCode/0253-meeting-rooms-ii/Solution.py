class Solution:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:
        '''
        sort using start time
        heap: end time 

        itereate interval:
            next start < end in the heap peak -> push
            else: pop peak and push
        
        len(heap)
        '''

        #sort using start time
        intervals.sort()

        heap = []

        for start, end in intervals:

            if heap and start >= heap[0]:
                heapq.heappop(heap)

            heapq.heappush(heap,end)
        
        return len(heap)


        