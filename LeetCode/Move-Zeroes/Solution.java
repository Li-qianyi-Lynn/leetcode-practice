class Solution {
    public void moveZeroes(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                deque.addFirst(nums[i]);

            }

        }
        for (int j = 0; j < nums.length;j++) {
            if (!deque.isEmpty()) {
                nums[j] = deque.removeLast();
            } else {
                nums[j] = 0;
            }
            

        }
        
    }
}