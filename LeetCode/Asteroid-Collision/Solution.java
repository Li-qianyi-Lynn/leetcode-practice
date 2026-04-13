1class Solution {
2    public int[] asteroidCollision(int[] asteroids) {
3        Deque<Integer> dq = new ArrayDeque<>();
4        for (int a : asteroids) {
5            boolean alive = true;
6            while (alive && !dq.isEmpty() && dq.peekLast() > 0 && a < 0) { // todo ? 
7                int cur = -a;
8                int peak = dq.peekLast();
9                if (cur == peak) { // boom
10                    dq.pollLast();
11                    alive = false;
12                } else if (cur < peak) { // boom
13                    alive = false;
14                } else {
15                    dq.pollLast();
16                }
17            }
18            if (alive) {
19                dq.offerLast(a);
20            }
21        }
22        // build res 
23        int n = dq.size();
24        int[] res = new int[n];
25        for (int i = 0; i < n; i++) {
26            res[i] = dq.pollFirst();
27        }
28        return res;
29
30
31        
32    }
33} 
34/**
35indices: relative position in space
36absolute value: size
37sign: dirs 
38 + right; 
39 - left
40
41rules:
421. If two asteroids meet, the smaller(size) one will explode.
432. same size, both boom
443. ++ / -- / -+ nothing happened -> +- they will boom
45
46[3,5,-6,2,-1,4]​​​​​​​
47
48-6,2,4
49
50stack to store the num in  asteroids
51for loop: if the peak and the num have the same directions, the size check which one will be added into the deque based on the rules;
52
53turn the dq into int[] -> res
54
55 */