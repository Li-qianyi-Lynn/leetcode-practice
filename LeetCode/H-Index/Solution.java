1class Solution {
2    public int hIndex(int[] citations) {
3        int l = 0;
4        int r = citations.length;
5        int res= 0;
6
7        while (l <= r) {
8            int mid = l + (r-l) /2; // temp h
9
10            int count = 0;
11            for (int c : citations) {
12                if (c >= mid) count++;
13            }
14
15            if (count < mid) {
16                r = mid-1;
17            } else {
18                res = mid;
19                l = mid+1;
20            }
21        }
22        return res;   
23    }
24}
25/**
26input int[] 
27index: ith paper ;
28citation[i]:  the number of citations a researcher received for their ith paper (likes for the paper i)
29
30
31output: int h: 
321) must have h paper
332) each paper has citations larger than k
34
35 0<= h <= citations.length
36 binary search
37
38citations[m]
390 1 2 3 4 5 6 
40      |
41 check if citations[i-1] >= 3 find three  ,l = mid, r = len 
42 return l
43
44
45 
46
47
48
49
50 */