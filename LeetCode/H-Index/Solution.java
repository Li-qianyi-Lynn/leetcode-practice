1class Solution {
2    public int hIndex(int[] citations) {
3        int n = citations.length;
4        
5        //binary search
6        int l = 1;
7        int r = citations.length;
8        int res = 0;
9        while (l <= r) {
10            int mid = l + (r-l)/2; 
11            //for loop: how many paper meet the requirement
12            int temp = 0;
13            for (int p : citations) {
14                if (p>= mid) { //  citations[i] >= h
15                    temp++;
16                }
17            }
18            if (temp >= mid) {
19                res = Math.max(res, mid);
20                l = mid + 1;
21            } else {
22                r = mid - 1;
23            }
24        }
25        return res;
26
27        
28    }
29}
30/**
31input: int[]
32output: int: h-idx
33            
34citations = [3,0,6,1,5]
35             0  1 2 3 4
36
37h: 
381. h <= len of citations 1-5 12345
392. citations[i] >= h
40
41符合h-idx 要求
42h-idx     understanding
431         1 paper 1 citation
442         2 paper each 2 citations
453         3 paper each 3 citations
46
47
481-5 inorder -> binary search
49l = 1
50r = 5
51
52
53
54 */