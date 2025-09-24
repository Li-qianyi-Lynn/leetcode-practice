class Solution {
    public int maxArea(int[] height) {
        
        int right = height.length-1; 
        int left = 0; 
        int maxA = 0; 
        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            maxA = Math.max(area, maxA); 
            
            if (height[right] < height[left]) {
                right --;             
            } else {
                left ++; 
            }     
        }
        return maxA; // 1
        
    }
}