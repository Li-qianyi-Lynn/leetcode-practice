1class Solution {
2    public int mySqrt(int x) {
3    if (x == 0 || x == 1) {
4        return x;
5    }
6    
7    int left = 1;
8    int right = x / 2;
9    
10    while (left <= right) {
11        int mid = left + (right - left) / 2;
12        long square = (long)mid * mid;
13        
14        if (square == x) {
15            return mid;
16        } else if (square < x) {
17            left = mid + 1;
18        } else {
19            right = mid - 1;
20        }
21    }
22    
23    return right; // right 是最后一个满足 mid*mid <= x 的值
24    }
25}