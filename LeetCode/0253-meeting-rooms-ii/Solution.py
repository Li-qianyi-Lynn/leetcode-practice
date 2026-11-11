class Solution:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:
        '''
        start 1
        end -1
        events []
        [0,1][5,1][10,-1][15,1][20,-1][30,-1]
        1. build event list: time,val
        2. sort the events nlogn 
        res = 0
        3. iterate the events list n
          cur_room :culculate the val
          res=max(cur_room,res)
        
        tc: nlogn
        sc: n 
        '''
        n = len(intervals)
        if n == 1:
            return 1
        
        events = []
        #1. build event list: time,val
        for start,end in intervals:
            events.append((start,1))
            events.append((end,-1))
        
        #2.sort
        events.sort()

        cur_room = 0
        max_room = 0

        #3. iterate the events list n
        for t,val in events:
            cur_room += val
            max_room = max(max_room,cur_room)
        
        return max_room



        