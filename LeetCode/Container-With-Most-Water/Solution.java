class Solution {
    public int maxArea(int[] height) {

    /**
    high level idea: two pointers: l r
    condition: if height[l] <= height[r],l++;
    else r--;

    area = (r - l) * Min(height[r],height[l])
    
     */

     //step1: initiate variables
     
    int l = 0;
    int r = height.length -1;
    int max = Integer.MIN_VALUE;

    //step2: use while loop to calculate the area
        while (l < r) {
            int area = (r - l) * Math.min(height[r], height[l]);
            max = Math.max(area, max);
            
            if (height[r] > height[l]) l++;
            else r--;
        }
        return max;
    }

}