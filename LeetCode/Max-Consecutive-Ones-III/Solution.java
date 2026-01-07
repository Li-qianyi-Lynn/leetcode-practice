    public int longestOnes(int[] A, int K) {
        
        int left = 0,   // start of the window
        max = 0,        // len of max valid window
        zeros = 0;      // number of zeros in a window 
        
        if(A == null || A.length == 0){
            return 0;
        }
        
        for(int i = 0 ; i < A.length ; i++){
            
            // Increase count of zero whenever you see one
            if(A[i]==0){
                zeros++;
            }
            
            // Shrink the window until zeros are equal less than required k
            while(left <= i && zeros > K){
                if(A[left] == 0){
                    zeros--;
                }   
                left++;
            }
            
            // At every step record the length of the window
            max = Math.max(max, i - left +1);
        } 
        
        return max;
    }