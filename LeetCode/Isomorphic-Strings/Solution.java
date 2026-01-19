1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        int[] mapS = new int[256];
4        int[] mapT = new int[256];
5
6        for(int i = 0; i < s.length(); i++) {
7            char charS = s.charAt(i);
8            char charT = t.charAt(i);
9            
10            if (mapS[charS] != mapT[charT]) {
11                return false;
12            }
13
14            mapS[charS] = i+1;
15            mapT[charT] = i+1; // 避开0， 初始化就是0
16
17
18        }
19        return true;
20        
21        
22    }
23}
24
25/**
26
27compare the positional patterns of characters in both strings. By tracking the last-seen index of each character using two integer arrays, we ensure that both strings follow an identical structure in a single pass with O(1) space.
28
29put strings into arrays
30
31the pattern: in the same position(i), their index should be same
32
33
34
35 */