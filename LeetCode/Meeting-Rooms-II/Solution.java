1class Solution {
2    public int minMeetingRooms(int[][] intervals) {
3        int room = 0;
4        int len = intervals.length;
5        int[] start = new int[len];
6        int[] end = new int[len];
7
8        for (int i = 0; i < len; i++) {
9            start[i] = intervals[i][0];
10            end[i] = intervals[i][1];
11
12        }
13
14        Arrays.sort(start);
15        Arrays.sort(end);
16
17        int endidx = 0;
18
19        for (int i = 0; i < len; i++) {
20            if (start[i] < end[endidx]) { // the event starts much early, need one moreroom
21                room++;
22            } else {
23                endidx++;
24            }
25        }
26        return room;   
27    }
28}
29
30/**
31线性扫描
32start int[]
33end int[]
34
35把时间放进对应的event 里
36sort
37endindex
38
39判断if start < end time
40-yes room++
41-no endindex++
42
43
44
45 */