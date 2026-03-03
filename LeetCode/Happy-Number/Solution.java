1class Solution {
2    public boolean isHappy(int n) {
3        Set<Integer> set = new HashSet<>();
4        while (n != 1 && !set.contains(n)) {
5            set.add(n);
6            n = getNext(n);
7        }
8
9        return n == 1;
10        
11    }
12
13    private int getNext(int n) {
14        int res = 0; // total sum
15        while (n != 0) {
16            int d = n % 10;
17            n = n / 10;
18            res += d * d;
19        }
20        return res;
21
22    }
23}
24
25/**
26
27get next num
284
2916
301+36 = 37
319 + 49 = 58
3225+64 89
3364 81 145
341 16 25 42
3520
364
37
38
39 */