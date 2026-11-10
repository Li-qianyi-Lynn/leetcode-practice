class Solution:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:
        events = []
        for start, end in intervals:
            events.append((start, 1))   # 会议开始，占用 +1
            events.append((end, -1))     # 会议结束，释放 -1
            
        # 排序规则：
        # 1. 先按时间戳升序排序
        # 2. 如果时间戳相同，优先处理结束事件（-1 排在 1 前面）
        events.sort(key=lambda x: (x[0], x[1]))
        
        max_rooms = 0
        current_rooms = 0
        
        for time, val in events:
            current_rooms += val
            max_rooms = max(max_rooms, current_rooms)
            
        return max_rooms 