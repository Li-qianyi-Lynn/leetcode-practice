1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        int curTank = 0;
4        int totalDiff = 0; // must >0 gas - cost 
5        int start = 0;
6
7        for (int i = 0; i < gas.length; i++) {
8            int diff = gas[i] - cost[i];
9            totalDiff += diff;
10            curTank += diff; // if < 0 that means we cant reach the next station
11
12            if (curTank < 0) {
13                start = i+1;
14                curTank = 0; // start again
15
16            }
17        }
18        return totalDiff >= 0 ? start : -1;
19   
20    }
21}
22
23/**
24
25规则 A：总油量必须大于总消耗
26
27算差值：先把 gas 和 cost 变成一个净增量的概念（gas[i] - cost[i]）。
28
29判总和：先看总账。如果总油量不够总消耗，直接判死刑（返回 -1）。
30
31找拐点：
32
33从 0 站出发，一边走一边累加。
34
35一旦累加和变成负数（这就叫“赤字”），说明之前那段路（从旧起点到现在这站）全都不行。
36
37清零，换下一站当起点重新出发。
38
39拿结果：当你走完最后一站，剩下的那个起点就是唯一答案（因为题目保证了如果有解则唯一）。
40
41
42
43 */