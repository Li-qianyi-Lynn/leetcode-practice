class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use map to restore the count of each integer
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num,count.getOrDefault(num,0) +1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int fre = entry.getValue();
            int num = entry.getKey();
            int[] element = new int[]{fre,num};

            heap.offer(element);
            if (heap.size() > k) {
                heap.poll();

            }

        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];

        }
        return res;
        
        
    }
}