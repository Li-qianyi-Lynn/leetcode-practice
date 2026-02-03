1
2class Solution {
3    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
4        PriorityQueue<Integer> pq = new PriorityQueue<>();
5        
6        // 将所有元素加入堆
7        for (int num : nums1) pq.offer(num);
8        for (int num : nums2) pq.offer(num);
9        
10        int totalLen = nums1.length + nums2.length;
11        
12        // 弹出前面的元素，直到到达中位数位置
13        for (int i = 0; i < (totalLen - 1) / 2; i++) {
14            pq.poll();
15        }
16        
17        if (totalLen % 2 != 0) {
18            return (double) pq.poll();
19        } else {
20            return (pq.poll() + pq.poll()) / 2.0;
21        }
22    }
23}