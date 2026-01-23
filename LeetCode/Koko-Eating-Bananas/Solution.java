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
15        int l = 1;
16        while (l < r) {
17            int mid = l + (r-l) / 2;
18            if (hoursUsed(piles, mid)<= h) { //todo
19                r = mid;
20
21            } else {
22                l = mid +1;
23            }
24        }
25        return l;
26        
27    }
28
29    private int hoursUsed(int[] piles, int speed) {
30    
31        int total = 0;
32        for (int pile : piles) {
33            int cur = 0;
34            cur = pile / speed;
35            if (pile % speed != 0) {
36                cur = cur+1;
37
38            }
39            total += cur;
40
41        }
42        return total;
43
44    }
45}
46
47/**
48k： speed
49find the min speed that koko can eat all bananas within h hours;
50
51bruteforce 
521- max speed 
53
54binary search 
55int[] is sorted in order (Monotonicity)
56
57
58l = 1
59r = max speed iterate piles ,get max piles[i]
60[1,2,3...5 67]
61         l
62         mid
63           r
64hoursUsed <= h
65
66while l < r 
67    int mid;
68    
69    hoursused <= h
70        speed can be the answer
71        r = mid;
72    hoursused > h koko eats too slow
73        l = mid +1;
74
75return l
76total 
77hour = counts of bananas in each pile / speed for one pile 
78if (counts of bananas in each pile % speed != 0) hour +1
79total += hour
80
81
82
83
84[30,11,23,4,20,30]
85h = 3
86sum safe way, but we have limitations here 
87
88 */
89 /**
90 
91 
92  */