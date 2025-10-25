class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) { // - 获取HashMap中所有的键值对
            int frequency = entry.getValue();  // 获取频次
            int number = entry.getKey();       // 获取数字
            int[] element = new int[]{frequency, number};  // 创建数组
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