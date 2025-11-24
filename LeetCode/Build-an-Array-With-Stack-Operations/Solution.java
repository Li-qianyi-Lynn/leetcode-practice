class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i = 1;
        
        for (int num : target) {
            while (i < num) {
                res.add("Push");
                res.add("Pop");
                i++;
            }
            
            // i == num, add it to the res
            res.add("Push");
            i++;
        }
        
        return res;

        
        
    }
}