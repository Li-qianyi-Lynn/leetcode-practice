

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int[] res = new int[k];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();
            int[] cur = new int[]{num, freq};

            if (minHeap.size() < k) {
                minHeap.offer(cur);
            } else {
                if (minHeap.peek()[1] < freq) {
                    minHeap.poll();
                    minHeap.offer(cur);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;   
    }
}

/**


heap <Integer, freq>



 */