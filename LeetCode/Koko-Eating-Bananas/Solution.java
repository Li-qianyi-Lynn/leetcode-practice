1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        // get max bananas in one pile
4        int maxBanana = 0;
5    
6        for (int pile : piles) {
7            maxBanana = Math.max(maxBanana,pile);
8        }
9        // pruning
10        
11
12
13        //main function
14        int r = maxBanana;
15        int res =r;
16        int l = 1;
17        while (l <= r) {
18            int mid = l + (r-l) / 2;
19            if (hoursUsed(piles, mid)<= h) { //todo
20                res = mid;
21                r = mid -1;
22
23            } else {
24                l = mid +1;
25            }
26        }
27        return res;
28        
29    }
30
31    private long hoursUsed(int[] piles, int speed) {
32    
33        long total = 0;
34        for (int pile : piles) {
35            long cur = 0;
36            cur = pile / speed;
37            if (pile % speed != 0) {
38                cur = cur+1;
39
40            }
41            total += cur;
42
43        }
44        return total;
45
46    }
47}
48
49/**
50k： speed
51find the min speed that koko can eat all bananas within h hours;
52
53bruteforce 
541- max speed 
55
56binary search 
57int[] is sorted in order (Monotonicity)
58
59
60l = 1
61r = max speed iterate piles ,get max piles[i]
62[1,2,3...5 67]
63         l
64         mid
65           r
66hoursUsed <= h
67
68while l < r 
69    int mid;
70    
71    hoursused <= h
72        speed can be the answer
73        r = mid;
74    hoursused > h koko eats too slow
75        l = mid +1;
76
77return l
78total 
79hour = counts of bananas in each pile / speed for one pile 
80if (counts of bananas in each pile % speed != 0) hour +1
81total += hour
82
83
84
85
86[30,11,23,4,20,30]
87h = 3
88sum safe way, but we have limitations here 
89
90 */
91 /**
92 
93 
94  */