1class Solution {
2    public int scheduleCourse(int[][] courses) {
3        // 按 deadline 升序排序
4        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
5        
6        // 大顶堆，存已选课程的 duration
7        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
8        
9        long totalTime = 0;
10        
11        for (int[] course : courses) {
12            int duration = course[0];
13            int lastDay = course[1];
14            
15            totalTime += duration;
16            maxHeap.offer(duration);
17            
18            if (totalTime > lastDay) {
19                // 超时，弹出当前耗时最大的课程
20                totalTime -= maxHeap.poll();
21            }
22        }
23        
24        return maxHeap.size();
25    }
26}