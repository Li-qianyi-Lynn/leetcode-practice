1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        int total = 0;
4        int curTank = 0;
5        int start = 0;
6        for (int i = 0; i < gas.length; i++) {
7            int diff = gas[i] - cost[i];
8            total += diff;
9            curTank += diff;
10            if (curTank < 0) {
11                start = i+1;
12                curTank = 0;
13            }
14
15        }
16        return total >= 0 ? start : -1;    
17    }
18}
19
20/**
21input :int[] gas, int[] cost
22output: int: the starting gas station's index  or -1
23
24
25rule : all gas we obtained >= we cost
26diff : gas[i] - cost[i]
27
28int total
29
30for loop to iterate gas[]
31how to find we cant come the next station?
32curTank < 0
33we should update the index -> we start the new journey +1
34 */