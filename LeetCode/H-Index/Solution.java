1class Solution {
2    public int hIndex(int[] citations) {
3        int l = 0;
4        int r = citations.length;
5        int res= 0;
6
7        while (l <= r) {
8            int mid = l + (r-l) / 2;
9
10            int count = 0;
11            for (int c : citations) {
12                if (c >= mid) {
13                    count++;
14
15                }
16            }
17            if (count >= mid) {
18                res = mid;
19                l = mid +1;   
20
21            } else {
22                r = mid-1;
23            }
24        }
25        return res;     
26    }
27}
28/**
29input int[] 
30index: ith paper ;
31citation[i]:  the number of citations a researcher received for their ith paper (likes for the paper i)
32
33
34output: int h: 
351) must have h paper
362) each paper has citations larger than k
37
38 0<= h <= citations.length
39 binary search
40
41citations[m]
420 1 2 3 4 5 6 
43      |
44 check if count of citations[i] >= 3 find three update res ,l = mid+1, 
45 return res
46
47
48 
49
50
51
52
53 */