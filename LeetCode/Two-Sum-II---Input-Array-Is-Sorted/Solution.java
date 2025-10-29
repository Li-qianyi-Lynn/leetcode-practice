class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tar = target - numbers[i];
            if (map.containsKey(tar)) {
                if (i < map.get(tar)) {
                    res[0] = i+1;
                    res[1] = map.get(tar)+1;
                    return res;

                } else {
                    res[1] = i+1;
                    res[0] = map.get(tar)+1;
                    return res;

                }

            }

            map.put(numbers[i], i);
        }
        return res;
        
    }
}