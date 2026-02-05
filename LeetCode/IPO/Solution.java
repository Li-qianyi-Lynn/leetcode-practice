1import java.util.*;
2
3class Solution {
4    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
5        int n = profits.length;
6        
7        // 1. 将项目按所需资本从小到大排序，创建一个二维数组或者自定义对象来存储 capital 和 profits 的对应关系
8        int[][] projects = new int[n][2];
9        for (int i = 0; i < n; i++) {
10            projects[i][0] = capital[i];
11            projects[i][1] = profits[i];
12        }
13        
14        // 按 capital 升序排列
15        Arrays.sort(projects, (a, b) -> a[0] - b[0]);
16
17        // 2. 最大堆：用于存储当前资本可以启动的所有项目的利润（利润大的在前）
18        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);
19
20        int projectIdx = 0;
21        
22        // 3. 进行 k 轮选择
23        for (int i = 0; i < k; i++) {
24            // 将所有当前资本 w 能够负担的项目放入最大堆
25            while (projectIdx < n && projects[projectIdx][0] <= w) {
26                maxProfitHeap.add(projects[projectIdx][1]);
27                projectIdx++;
28            }
29
30            // 如果最大堆为空，说明剩下的项目都买不起，直接跳出
31            if (maxProfitHeap.isEmpty()) {
32                break;
33            }
34
35            // 贪心选择：选利润最大的项目，更新当前资本
36            w += maxProfitHeap.poll();
37        }
38
39        return w;
40    }
41}