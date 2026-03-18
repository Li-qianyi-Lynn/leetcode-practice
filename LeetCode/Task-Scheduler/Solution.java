1class Solution {
2    public int leastInterval(char[] tasks, int n) {
3
4        // greedy 每次处理出现频率最高的任务
5
6        int[] c = new int[26]; // 统计每个任务出现频率
7        for ( char task : tasks ) {
8            c[task - 'A'] ++;
9        }
10
11        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
12        for (int cMore : c) {
13            if ( cMore > 0) {
14                maxHeap.offer(cMore);
15            }       
16        }
17
18        int time = 0;
19        Queue<int[]> q = new LinkedList<>();
20        while (!maxHeap.isEmpty() || !q.isEmpty()) {
21            time ++;
22
23            if (maxHeap.isEmpty()) {
24                time = q.peek()[1];
25            } else {
26                int cnt = maxHeap.poll() - 1;
27                if (cnt > 0) {
28                    q.add(new int[]{cnt, time + n});
29                }
30            }
31
32            if (!q.isEmpty() && q.peek()[1] == time) {
33                maxHeap.add(q.poll()[0]);
34            }
35        }
36        return time;   
37    }
38}