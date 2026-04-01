1class Solution {
2    public String gcdOfStrings(String str1, String str2) {
3        if (!(str1 + str2).equals(str2+ str1)) {
4            return "";
5        }
6        int gcd = gcdLen(str1.length(), str2.length());
7        return str1.substring(0,gcd);
8
9
10        
11    }
12
13    private int gcdLen(int a, int b) {
14        if (b == 0) {
15            return a;
16        }
17
18        return gcdLen(b, a % b);
19    } 
20}
21/**
22input: string1 string2
23output: String x
24
251. check if str1 and str2 have totally same chars-> if they have common divisor of strings
262. find the gcd -> a,b  gcd = ?
27
28 */