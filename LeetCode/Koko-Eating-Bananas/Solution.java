class Solution {
    // plan ：1. find max in int[] piles 2. binary search  1-max 3. each time = piles[i] / k + piles[i] % k(if != 0, +1) 4. add all time , if all < h, binary search 
    public int minEatingSpeed(int[] piles, int h) {
        // 1. find max Pile 
        int maxPile = 0;
        for (int pile : piles) {
            if (pile > maxPile) {
                maxPile = pile;
            }
        }
        if (piles.length == h) {
            return maxPile;
        }
        // 2. binary search 
        int l = 1;
        int r = maxPile;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int tempHour = calculateHour(piles,mid);
            if (tempHour <= h) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;   
    }

    private int calculateHour(int[] piles, int mid) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += piles[i] / mid;
            if (piles[i] % mid != 0) {
                res ++;
            }
        }
        return res;
    }
}