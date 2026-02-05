1import java.util.*;
2
3class Solution {
4    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
5        int n = profits.length;
6        int[][] projects = new int[n][2]; // n projects, 2 (profit + capital)
7        for (int i = 0; i < n; i++) {
8            projects[i][0] = capital[i];
9            projects[i][1] = profits[i];
10
11        }
12        // sorted capital
13        Arrays.sort(projects, (a,b)-> a[0] - b[0]);
14        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a); // profit
15
16        int cur = 0;
17        for (int i = 0; i < k; i++) {
18            while (cur < n && projects[cur][0] <= w) {
19                maxHeap.add(projects[cur][1]);
20                cur++;
21            }
22            if (maxHeap.isEmpty()) {
23                break;
24
25            }
26
27            w += maxHeap.poll();
28
29        }
30        return w;
31        
32    }
33}
34/**
351. match capital and profit
362. sorted capital , use less capital, get max profit
373. k limitations, process max profit: maxHeap
384. for (i-k) {
39    projectid < n, capital <= w : add it to the heap,
40    w +=maxProfitHeap.poll();
41
42
43}
44
45
46
47 */