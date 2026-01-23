1import java.util.Arrays;
2
3class Solution {
4    public int hIndex(int[] citations) {
5        int r = citations.length;
6        int l = 0;
7        int res = 0;
8        while (l <= r) {
9            int mid = l + (r-l)/2;
10            int count = 0; // 多少paper citations >= mid
11            for (int i = 0; i < citations.length; i++) {
12                if (citations[i] >= mid) {
13                    count ++;
14                }
15            }
16            if (mid <= count) {
17                res = Math.max(res, mid);
18                l = mid+1;
19            } else {
20                r = mid-1;
21            }
22
23        }
24        return res;   
25    }
26}
27
28/**
29
30[1,1,3]
31   |
32input: citations[]
33citations:[3, 0,6,1,5] 5
34paper id  0. 1. 2 3 4
35
36h: this researcher must have h papers: h <= length.citations
37
38h - index: 3
391. researcher has published at least h papers: min paper nums 0-5
402. citation: at least h papers that each has h or more citations
41
42h: [0,len of citations] 0,1,2,3,4,5 
43citations[i] >= mid count ++;
44
45[65310]
461. sorted citations
472. iterate []
48
49
50
51
52
53
54
55
56 */