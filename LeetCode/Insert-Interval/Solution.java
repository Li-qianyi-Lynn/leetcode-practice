1class Solution {
2    public int[][] insert(int[][] intervals, int[] newInterval) {
3        if (intervals.length == 0) {
4            return new int[][]{newInterval};
5
6        }
7        int len = intervals.length;
8        List<int[]> res = new ArrayList<>();
9
10        for (int i = 0; i < len; i++) {
11            if (newInterval == null) {
12                res.add(intervals[i]);
13                continue;
14
15            }
16            /**
17             [][]
18          []
19            
20             */
21            if (newInterval[1] < intervals[i][0]) {
22                res.add(newInterval);
23                newInterval = null;
24                res.add(intervals[i]);
25
26            } else if (newInterval[0] > intervals[i][1]) {
27                res.add(intervals[i]);
28
29            } else if (newInterval != null ) {
30                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
31                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
32
33            }
34
35        }
36        if (newInterval != null) {
37            res.add(newInterval);
38        }
39        
40        return res.toArray(new int[res.size()][2]);
41
42        
43    }
44}
45
46/**
47  [][]
48[]..
49
50
51[]..[]
52  []
53
54
55 [ ][ ]
56  [. ]
57
58
59
60 */