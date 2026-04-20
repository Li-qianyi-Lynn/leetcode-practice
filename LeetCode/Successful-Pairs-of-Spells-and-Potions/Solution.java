1class Solution {
2    public int[] successfulPairs(int[] spells, int[] potions, long success) {
3        int n = spells.length;
4        int m = potions.length;
5        int[] res = new int[n];
6        Arrays.sort(potions);// s = l
7
8        for (int i = 0; i < n; i++) {
9            int s = spells[i];
10            // binary search
11            int l = 0;
12            int r = m-1;
13            int minPotionIdx = m;
14            while (l <= r) {
15                int mid = l + (r - l)/2;
16
17                if ((long)s * potions[mid] >= success) {
18                    minPotionIdx = mid;
19                    r = mid - 1;
20                } else {
21                    l = mid + 1;
22                }
23            }
24            // count 
25            res[i] = m - minPotionIdx;
26        }
27        return res;
28        
29    }
30}
31/**
32input: int[] spells n, int[] potions m(not sorted, one num can appear several times), int success
33output:int[] pairs n
34
35product: s * p >= success
36
371. sort the potions
382. we can know the minPotion index, all other index => the minpotion index  -> binary search
393. calculate the count
40
41 
42
43 */