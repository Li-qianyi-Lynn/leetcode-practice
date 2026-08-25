1class Solution {
2    public int scheduleCourse(int[][] courses) {
3        Arrays.sort(courses, (a,b) -> Integer.compare(a[1],b[1]));
4
5        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
6        int total = 0;
7
8        for (int[] course : courses) {
9            int duration = course[0];
10            int lastday = course[1];
11            total += duration;
12
13            maxHeap.offer(duration);
14            if (total > lastday) {
15                total -= maxHeap.poll();
16            }
17
18        }
19        return maxHeap.size();
20
21
22
23    }
24}
25/**
26
27sort using lastDay
28
29maxHeap -> duration
30
31
32
33
34
35 */