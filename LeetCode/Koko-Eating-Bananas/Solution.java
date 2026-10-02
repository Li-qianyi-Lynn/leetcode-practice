1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        // get max bananas in one pile
4        int maxBanana = 0;
5
6        for (int pile : piles) {
7            maxBanana = Math.max(maxBanana, pile);
8        }
9
10        //main function
11        int r = maxBanana;
12        int res = r;
13        int l = 1;
14        while (l <= r) {
15            int mid = l + (r - l) / 2;
16            if (hoursUsed(piles, mid) <= h) { //todo
17                res = mid;
18                r = mid - 1;
19
20            } else {
21                l = mid + 1;
22            }
23        }
24        return res;
25
26    }
27
28    private long hoursUsed(int[] piles, int speed) {
29
30        long total = 0;
31        for (int pile : piles) {
32            long cur = 0;
33            cur = pile / speed;
34            if (pile % speed != 0) {
35                cur = cur + 1;
36
37            }
38            total += cur;
39
40        }
41        return total;
42
43    }
44}
45
46/**
47k： speed
48find the min speed that koko can eat all bananas within h hours;
49
50bruteforce 
511- max speed 
52
53binary search 
54int[] is sorted in order (Monotonicity)
55
56
57l = 1
58r = max speed iterate piles ,get max piles[i]
59[1,2,3...5 67]
60         l
61         mid
62           r
63hoursUsed <= h
64
65while l < r 
66    int mid;
67    
68    hoursused <= h
69        speed can be the answer
70        r = mid;
71    hoursused > h koko eats too slow
72        l = mid +1;
73
74return l
75total 
76hour = counts of bananas in each pile / speed for one pile 
77if (counts of bananas in each pile % speed != 0) hour +1
78total += hour
79
80
81
82
83[30,11,23,4,20,30]
84h = 3
85sum safe way, but we have limitations here 
86
87 */
88/**
89
90
91 */