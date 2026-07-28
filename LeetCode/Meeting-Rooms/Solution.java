1class Solution {
2    public boolean canAttendMeetings(int[][] intervals) {
3        if (intervals.length <= 1) {
4            return true;
5        }
6
7        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
8
9        for (int i = 1; i < intervals.length; i++) {
10            if (intervals[i][0] < intervals[i-1][1]) {
11                return false;
12
13            }
14
15
16        }
17        return true;
18
19        
20
21
22        
23    }
24}
25
26/**
271. sort using starti
282, post start < pre end -> return false
29
30
31
32 */