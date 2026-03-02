1class Solution {
2    private int getNext(int n) {
3        int totalSum = 0;
4        while (n > 0) {
5            int d = n % 10;    
6            n = n / 10;          
7            totalSum += d * d;   
8        }
9        return totalSum;
10    }
11    
12    public boolean isHappy(int n) {
13        Set<Integer> seen = new HashSet<>();  
14        
15        
16        while (n != 1 && !seen.contains(n)) {
17            seen.add(n);         
18            n = getNext(n);      
19        }
20        
21
22        return n == 1;
23    }
24}