1class Solution {
2    public int hIndex(int[] citations) {
3        
4
5        int l = 0;
6        int r = citations.length;
7        int res = 0;
8        while (l <= r) {
9            int mid = l + (r-l)/2;
10            int count = 0;
11            for (int i = 0; i < citations.length; i++) {
12                if (citations[i] >= mid) {
13                    count++;
14                }
15
16            }
17            if (count >= mid) {
18                res = Math.max(res,mid);
19                l = mid+1;
20
21            } else {
22                r = mid-1;
23            }
24        }
25        return res;
26        
27    }
28}
29/**
30
31h: max
321. h: 0-len
332. each paper has been cited at least h times
34
35binary search
360. 5
37check if nums[i] >= mid
38if yes , count ++
39
40check if count >= mid
41if yes, answer = max mid, l = mid +1
42if no, r = mid -1
43 */