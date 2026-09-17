1class Solution {
2    public int[] getOrder(int[][] tasks) {
3        int n = tasks.length;
4        
5        if (n == 1) {
6            return new int[]{0};
7        }
8        //init processed int[][]:[enqueueTimei, processingTimei,index]
9        int[] res = new int[n];
10        int taskId = 0;
11        int[][] sorted = new int[n][3];
12        for (int i = 0; i < n; i++) {
13            int[] task = tasks[i];
14            int enqueueTime = task[0];
15            int processingTime = task[1];
16            int idx = i;
17            sorted[i] = new int[]{enqueueTime,processingTime, idx};
18        }
19
20        // sort by enqueue time
21        Arrays.sort(sorted, (a,b) ->Integer.compare(a[0],b[0]));
22
23        // minHeap: sort by processingTime and index
24        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> {
25            if (a[1] != b[1]) {
26                return Integer.compare(a[1],b[1]);
27
28            } else {
29                return Integer.compare(a[2],b[2]);
30
31            }
32
33        });
34
35        int curTime = 0;
36        int i = 0;
37        // for loop processed 
38        while (taskId < n ||!minHeap.isEmpty()) {
39            if (minHeap.isEmpty() && curTime < sorted[i][0]) {
40                curTime = sorted[i][0];
41            }
42
43            while (i < n && sorted[i][0] <= curTime) {
44                minHeap.offer(sorted[i]);
45                i++;
46            }
47
48            int[] task = minHeap.poll();
49            curTime += task[1];       
50            res[taskId++] = task[2];   
51
52        }
53        
54        return res;
55        
56       
57
58
59        
60    }
61}
62/**
63 int[]:[enqueueTimei, processingTimei,index]
64
65
66
67
68
69 */