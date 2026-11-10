class Solution:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:
        events = []
        for start, end in intervals:
            events.append((start,1))
            events.append((end,-1))

        events.sort(key = lambda x:(x[0],x[1]))

        cur_room = 0
        res = 0
        for time,val in events:
            cur_room += val
            res = max(res,cur_room)
        return res



        