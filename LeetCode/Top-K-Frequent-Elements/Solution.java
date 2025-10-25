class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // map: store num(key) and its frequency(value)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //put K-V pait to the pq, and do the comperation
        // min heap: heap topwill store the least frequent element, if the size is larger than k, we can just pop out he top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(Map.Entry<Integer, Integer> pair: map.entrySet()) {
            int freq = pair.getValue();
            int num = pair.getKey();
            int[] element = new int[]{num, freq};
            pq.offer(element);

            if (pq.size() > k) {
                pq.poll();

            }

        }

        // add num to the res list;
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];

        }
        return res;
        
    }
}