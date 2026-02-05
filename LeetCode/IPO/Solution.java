1import java.util.*;
2
3class Solution {
4    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
5        int n = profits.length;
6        int[][] match = new int[n][2]; // n projects, 2 (profit + capital)
7        for (int i = 0; i < n; i++) {
8            match[i][0] = capital[i];
9            match[i][1] = profits[i];
10
11        }
12
13        // sorted capital
14        Arrays.sort(match, (a,b)-> a[0] - b[0]);
15        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a); // profit
16
17        int cur = 0;
18        for (int i = 0; i < k; i++) {
19            while (cur < n && match[cur][0] <= w) {
20                maxHeap.add(match[cur][1]);
21                cur++;
22            }
23            if (maxHeap.isEmpty()) {
24                break;
25
26            }
27
28            w += maxHeap.poll();
29
30        }
31        return w;
32        
33    }
34}
35/**
361. match capital and profit
372. sorted capital , use less capital, get max profit
383. k limitations, process max profit: maxHeap
394. for (i-k) {
40    projectid < n, capital <= w : add it to the heap,
41    w +=maxProfitHeap.poll();
42
43
44}
45
46
47
48 */