1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        // use min pq to store the frequency
4        PriorityQueue<Integer> pq = new PriorityQueue<>();
5
6        //put num into pq
7        for (int num : nums) {
8            pq.offer(num);
9
10            if (pq.size() > k) {
11                pq.poll(); // remove the smallest one (top of the heap)
12            }
13        }
14
15        return pq.peek();
16        
17    }
18}