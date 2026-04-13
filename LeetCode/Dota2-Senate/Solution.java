1class Solution {
2    public String predictPartyVictory(String senate) {
3        Deque<Integer> radiant = new ArrayDeque<>();
4        Deque<Integer> dire = new ArrayDeque<>();
5        int n = senate.length();
6
7        for (int i = 0; i < n; i++) {
8            char c = senate.charAt(i);
9            if (c == 'R') {
10                radiant.offerLast(i);
11            } else {
12                dire.offerLast(i);
13            }
14        }
15
16        while (!radiant.isEmpty() && !dire.isEmpty()) {
17            int indexR = radiant.pollFirst();
18            int indexD = dire.pollFirst();
19            if (indexR < indexD) {
20                radiant.offerLast(indexR + n);
21            } else {
22                dire.offerLast(indexD + n);
23            }
24        }
25        return radiant.isEmpty() ? "Dire" : "Radiant";
26        
27    }
28}