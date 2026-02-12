1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        int curTank = 0;
4        int total = 0;
5        int start = 0;
6        int n = gas.length;
7        for (int i = 0; i < n; i++) {
8            int diff = gas[i]- cost[i];
9            total += diff;
10            curTank += diff;
11            if (curTank < 0) {
12                start = i+1;
13                curTank = 0;
14            }
15
16        }
17        return total >= 0 ? start : -1;
18    }
19}
20
21/**
22input :int[] gas, int[] cost
23output: int: the starting gas station's index  or -1
24
25
26rule : all gas we obtained >= we cost
27diff : gas[i] - cost[i]
28
29int total
30
31for loop to iterate gas[]
32how to find we cant come the next station?
33curTank < 0
34we should update the index -> we start the new journey +1
35 */