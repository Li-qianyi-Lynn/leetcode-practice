1class Solution {
2    public int lengthOfLastWord(String s) {
3        int n = s.length();
4        int count = 0;
5        int endidx = 0;
6        for (int i = n-1; n >= 0; i--) {
7            char c = s.charAt(i);
8            if (c != ' ') {
9                endidx = i;
10                break;
11            }
12        }
13        for (int i = endidx; i >= 0; i--) {
14            char c = s.charAt(i);
15            if (c != ' ') {
16                count++;
17
18            } else {
19                break;
20            }
21        }
22        return count;
23        
24    }
25}
26/**
27
28iterate from the last char
29count++
30meet empty, break
31
32
33
34 */