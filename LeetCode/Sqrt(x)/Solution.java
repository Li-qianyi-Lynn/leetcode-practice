class Solution {
    public int mySqrt(int x) {
    if (x == 0 || x == 1) {
        return x;
    }
    
    int left = 1, right = x / 2;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        long square = (long)mid * mid;
        
        if (square == x) {
            return mid;
        } else if (square < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return right; // right 是最后一个满足 mid*mid <= x 的值
}
}