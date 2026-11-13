class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket = new List[len + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);

    
        }

        for (int i = len; i >= 0; i--) {
            if (bucket[i] != null && k > 0) {
                for (int bu : bucket[i]) {
                    res[k-1] = bu;
                    k--;

                }
            }

        }
        return res;
        
    }
}

/**
bucket sort

map: num -> freq
int[len+1] bucket -> 
i: freq 
bucket[i] : num

from end to the begining
if bucket[i] != null, add bucket[i] to the res



 */