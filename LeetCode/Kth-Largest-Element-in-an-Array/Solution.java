1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
4        for (int num : nums) {
5            minHeap.offer(num);
6            if (minHeap.size() > k) {
7                minHeap.poll();
8
9            }
10
11        }
12        return minHeap.peek();
13        
14    }
15}
16/**
17
18
19minHeap
20pq
21
22
23 */