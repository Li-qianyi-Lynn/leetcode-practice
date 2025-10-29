class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];

        int r = numbers.length -1;
        int l = 0;
        while (l < r) {
        

            if ( numbers[l] + numbers[r] < target) {
                l ++;


            } else if ( numbers[l] + numbers[r] > target) {
                r --;
            } else {
                ans[0] = l +1;
                ans[1] = r +1;
                break;

            }

        }

        return ans;


        
    }
}
