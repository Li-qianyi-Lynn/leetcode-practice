1class Solution {
2    public int minMeetingRooms(int[][] intervals) {
3        int n = intervals.length;
4        int room = 0;
5
6        // 存开始时间和结束时间
7        int[] starts = new int[n];
8        int[] ends = new int[n];
9
10        for (int i = 0; i < n; i++) {
11            starts[i] = intervals[i][0];
12            ends[i] = intervals[i][1];
13        }
14        Arrays.sort(starts);
15        Arrays.sort(ends);
16
17        int endIndex = 0;
18        for (int j = 0; j < n; j++) {
19            if (starts[j] < ends[endIndex]) {
20                room++;
21            } else {
22                endIndex++;
23            }
24        }
25        return room;
26        
27    }
28}
29
30/**
31开始时间 结束时间都记录下来 做个排序
32比较在开始的时候有没有会议能结束，如果不能结束的话，room++
33
34
35 */