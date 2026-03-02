1class Solution {
2    public boolean isHappy(int n) {
3        int slow = n;
4        int fast = n;
5
6        while (fast != 1) {
7            slow = getNext(slow);
8            fast = getNext(getNext(fast));
9            if (slow == fast && slow != 1) {
10                return false;
11
12            }
13
14        }
15        return true;
16        
17    }
18
19    private int getNext(int n) {
20        int res = 0; // total sum
21        while (n != 0) {
22            int d = n % 10;
23            n = n / 10;
24            res += d * d;
25        }
26        return res;
27
28    }
29}
30
31/**
32
33get next num
344
3516
361+36 = 37
379 + 49 = 58
3825+64 89
3964 81 145
401 16 25 42
4120
424
43
44
45 */