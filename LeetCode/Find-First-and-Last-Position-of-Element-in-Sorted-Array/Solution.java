1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        // int[] result = {-1, -1};
4        
5        // if (nums.length == 0) {
6        //     return result;
7        // }
8        
9        // result[0] = findLeftBound(nums, target);
10        
11        // if (result[0] == -1) {
12        //     return result;
13        // }
14        
15        // result[1] = findRightBound(nums, target);
16        
17        return new int[] {findLeftBound(nums,target),findRightBound(nums,target)};
18    }
19    
20    private int findLeftBound(int[] nums, int target) {
21        int left = 0;
22        int right = nums.length - 1;
23        int result = -1;
24        
25        while (left <= right) {
26            int mid = left + (right - left) / 2;
27            
28            if (nums[mid] == target) {
29                result = mid; 
30                right = mid - 1; 
31            } else if (nums[mid] < target) {
32                left = mid + 1;
33            } else {
34                right = mid - 1;
35            }
36        }
37        
38        return result;
39    }
40    
41    private int findRightBound(int[] nums, int target) {
42        int left = 0;
43        int right = nums.length - 1;
44        int result = -1;
45        
46        while (left <= right) {
47            int mid = left + (right - left) / 2;
48            
49            if (nums[mid] == target) {
50                result = mid;  
51                left = mid + 1;  
52            } else if (nums[mid] < target) {
53                left = mid + 1;
54            } else {
55                right = mid - 1;
56            }
57        }
58        
59        return result;
60    }
61}