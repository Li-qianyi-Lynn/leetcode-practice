1class Solution {
2    public int[] sortArray(int[] nums) {
3        if (nums.length == 1) {
4            return nums;
5
6        }
7        mergeSort(nums, 0, nums.length-1);
8        return nums;
9        
10    }
11
12    private void mergeSort(int[] nums, int l, int r) {
13        if (l >= r) return; 
14        int mid = l + (r-l)/2;
15        mergeSort(nums, l, mid);
16        mergeSort(nums, mid+1, r);
17        merge(nums, l, mid, r);
18
19    }
20
21    private void merge(int[] nums, int left, int mid, int right) {
22        int[] temp = new int[right - left + 1]; // left- mid  mid+1 - right
23        int s1 = left;
24        int s2 = mid+1;
25        int k = 0;
26
27        while (s1 <= mid && s2 <= right) {
28            if (nums[s1] <= nums[s2]) {
29                temp[k++] = nums[s1++];
30            } else {
31                temp[k++] = nums[s2++];
32            }
33
34        }
35
36        while (s1 <= mid) temp[k++] = nums[s1++];
37        while (s2 <= right) temp[k++] = nums[s2++];
38
39        System.arraycopy(temp, 0, nums, left, temp.length);
40
41    }
42}