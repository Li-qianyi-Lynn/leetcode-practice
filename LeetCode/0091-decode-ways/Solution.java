class Solution {
    public int numDecodings(String s) {
        // edge case
        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int n = s.length();
        int[] dp = new int[n+1];

        // init
        dp[0] = 1;

        for (int i = 1; i < n+1; i++) {
            // single 
            if (s.charAt(i-1) != '0') {
                 dp[i] += dp[i-1];
            }
            // double int
            if (i-2 >= 0) {
                int doubleInt = Integer.parseInt(s.substring(i-2,i)); //todo
                if (doubleInt <= 26 && doubleInt >= 10) {
                    dp[i] += dp[i-2];

                }
            }
        }
        return dp[n];
        
    }
}
/**
input: String s
output: the num of ways to decode s


start from 0 can't be decodes

two ways:

single int: 1
double int: 1

dp/dfs

// single int 
dp[i] += dp[i-1];


// double int 
// check int -> 10 - 26
dp[i] += dp[i-2];


  0| 2     2   6
  0  i-2  i-1  i

return dp[i]




 */