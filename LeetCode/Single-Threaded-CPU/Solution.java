1class Solution {
2    public int[] getOrder(int[][] tasks) {
3        int n = tasks.length;
4        int[][] sortedTasks = new int[n][3];
5        for (int i = 0; i < n; i++) {
6            sortedTasks[i][0] = tasks[i][0];
7            sortedTasks[i][1] = tasks[i][1];
8            sortedTasks[i][2] = i; // 直接把原始下标绑定进去
9        }
10        // 1. 扩充数组，存 [enqueueTime, processingTime, originalIndex]
11        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
12
13        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
14            if (a[1] != b[1]) {
15                return Integer.compare(a[1], b[1]);
16            }
17            return Integer.compare(a[2], b[2]);
18        });
19
20        int[] result = new int[n];
21        int resIdx = 0;
22        int taskIdx = 0;
23        long curTime = 0;
24
25        while (resIdx < n) {
26            // idle直接跳
27            if (pq.isEmpty() && curTime < sortedTasks[taskIdx][0]) {
28                curTime = sortedTasks[taskIdx][0];
29
30            }
31            //将所有已到达的任务加入堆
32            while (taskIdx < n && sortedTasks[taskIdx][0] <= curTime) {
33                pq.offer(sortedTasks[taskIdx]);
34                taskIdx++;
35
36            }
37
38            // 取出耗时最短（或下标最小）的任务执行
39            int[] curTask = pq.poll();
40            curTime += curTask[1];
41            result[resIdx] = curTask[2];
42            resIdx++;
43
44        }
45        return result;
46    }
47
48}
49/**
50
51sort using enqueueTime
52
53
54minheap: time -> original index
55
56
57 */