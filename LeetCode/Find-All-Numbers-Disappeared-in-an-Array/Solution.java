class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num: nums) {
            set.add(num);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= nums.length; i++) {
            deque.offerLast(i);
            if (set.contains(i)) {
                deque.pollLast();
            }

        }
        while (!deque.isEmpty()) {
            res.add(deque.pollLast());

        }
        return res;
        


        
    }
}