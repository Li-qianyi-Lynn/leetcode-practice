1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        List<Integer> list = new ArrayList<>();
4        for (int num : nums) {
5            list.add(num);
6
7        }
8        return quickSelect(list,k);
9        
10
11        
12    }
13
14    private int quickSelect(List<Integer> nums, int k) {
15        int pivotIndex = new Random().nextInt(nums.size());
16        int pivot = nums.get(pivotIndex);
17        List<Integer> mid = new ArrayList<>();
18        List<Integer> left = new ArrayList<>();
19        List<Integer> right = new ArrayList<>();
20        for (int num : nums) {
21            if (num > pivot) {
22                left.add(num);
23            } else if (num < pivot) {
24                right.add(num);
25            } else {
26                mid.add(num);
27            }
28        }
29        int res = 0;
30        if (left.size() >= k) {
31            return quickSelect(left, k);  
32        } else if (k > left.size() + mid.size()) {
33            return quickSelect(right, k - left.size()-mid.size());
34
35        } else {return pivot;}
36
37    }
38}
39/**
40quick select
41left: big
42mid : same
43right : small 
44
45
46 */