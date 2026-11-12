class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);

        }
        return quickSelect(list,k);
        

        
    }

    private int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);
        List<Integer> mid = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                left.add(num);
            } else if (num < pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }
        int res = 0;
        if (left.size() >= k) {
            return quickSelect(left, k);  
        } else if (k > left.size() + mid.size()) {
            return quickSelect(right, k - left.size()-mid.size());

        } else {return pivot;}

    }
}
/**
quick select
left: big
mid : same
right : small 


 */