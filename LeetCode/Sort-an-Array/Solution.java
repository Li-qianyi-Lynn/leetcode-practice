1class Solution {
2    public int[] sortArray(int[] nums) {
3        quickSort(nums, 0, nums.length - 1);
4        return nums;
5    }
6    
7    private void quickSort(int[] nums, int left, int right) {
8        if (left >= right) return;
9        
10        int pivotIndex = partition(nums, left, right);
11        quickSort(nums, left, pivotIndex - 1);
12        quickSort(nums, pivotIndex + 1, right);
13    }
14    
15    private int partition(int[] nums, int left, int right) {
16        // 随机选择 pivot 避免最坏情况
17        int randomIndex = left + (int)(Math.random() * (right - left + 1));
18        swap(nums, randomIndex, right);
19        
20        int pivot = nums[right];
21        int i = left;
22        
23        for (int j = left; j < right; j++) {
24            if (nums[j] < pivot) {
25                swap(nums, i, j);
26                i++;
27            }
28        }
29        swap(nums, i, right);
30        return i;
31    }
32    
33    private void swap(int[] nums, int i, int j) {
34        int temp = nums[i];
35        nums[i] = nums[j];
36        nums[j] = temp;
37    }
38}