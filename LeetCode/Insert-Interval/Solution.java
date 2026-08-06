1class Solution {
2    public int[][] insert(int[][] intervals, int[] newInterval) {
3        if (intervals.length == 0) {
4            return new int[][]{newInterval};
5        }
6
7        List<int[]> res = new ArrayList<>();
8
9        int n = intervals.length;
10        for (int i = 0; i < n; i++) {
11            if (newInterval != null && intervals[i][0] > newInterval[1]) {
12                res.add(newInterval);
13                newInterval = null;
14                res.add(intervals[i]);
15            } else if (newInterval == null || intervals[i][1] < newInterval[0]) {
16                res.add(intervals[i]);
17            } else {
18                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
19                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
20            }
21        }
22
23        if (newInterval != null) {
24            res.add(newInterval);
25        }
26        return res.toArray(new int[res.size()][]);
27        
28    }
29}
30/**
31con1
32...[ ] ....
33[]....
34
35con2
36...[ ]....[ ]
37......[ ].
38
39con3
40...[ ]...
41..[ ]...
42
43 */