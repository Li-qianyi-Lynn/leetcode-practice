class Solution {
    public int findKthLargest(int[] nums, int k) {
        // use min pq to store the frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        //put num into pq
        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll(); // remove the smallest one (top of the heap)
            }
        }

        return pq.peek();
        
    }
}