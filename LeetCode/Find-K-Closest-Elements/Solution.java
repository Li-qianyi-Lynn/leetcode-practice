1class Solution {
2    public List<Integer> findClosestElements(int[] arr, int k, int x) {
3        int n = arr.length;
4        List<Integer> res = new ArrayList<>();
5         // edge cases
6
7
8        if (k == n) {
9            for (int a : arr) {
10                res.add(a);
11
12            }
13            return res;
14
15        }
16       
17        if (arr[0] > x) {
18            for (int i = 0; i < k; i++) {
19                res.add(arr[i]);
20            }
21            return res;
22
23        }
24
25        if (arr[n-1] < x) {
26            for (int i = n-k; i < n; i++) {
27                res.add(arr[i]);
28
29            }
30            return res;
31
32        }
33
34        // 1.  在单调递增数组中，找到第一个大于或等于 x 的元素的索引。
35        int left = 0;
36        int right = n - 1;
37        int idx = 0;
38        while (left <= right) {
39            int mid = left + (right - left) / 2;
40            if (arr[mid] >= x) {
41                idx = mid;
42                right = mid - 1;
43            } else {
44                left = mid + 1;
45            }
46        }
47
48        // 2. 初始化双指针，中心扩散选出 k 个元素
49        int l = idx-1; 
50        int r = idx;
51
52        while (r - l - 1 < k) { //开区间
53            if (l < 0) {
54                r++;
55            } else if (r >= n) {
56                l--;
57            } else {
58                // 比较距离
59                if (x - arr[l] <= arr[r] - x) {
60                    l--; // 选左边
61                } else {
62                    r++; // 选右边
63                }
64            }
65        }
66
67        // 构建答案
68        for (int i = l+1; i < r; i++) {
69            res.add(arr[i]);
70        }
71        return res;
72    }
73}
74