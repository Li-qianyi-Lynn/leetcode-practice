1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        Map<Integer, List<Integer>> map = new HashMap<>();
4        int[] status = new int[numCourses];// index: courseNum value: status
5        for (int[] pre : prerequisites) {
6            if (!map.containsKey(pre[0])) {
7                map.put(pre[0], new ArrayList<>());
8            }
9            map.get(pre[0]).add(pre[1]);
10        }
11
12        for (int i = 0; i < numCourses; i++) {
13            if (!dfs(i, map, status )) {
14                return false;
15            } //todo
16
17        }
18        return true;
19        
20    }
21
22    private boolean dfs(int course, Map<Integer, List<Integer>> map, int[] status) {
23        if (status[course] == 1) {
24            return false;
25
26        }
27        if (status[course] == 2) {
28            return true;
29
30        }
31
32        status[course] = 1;
33        List<Integer> pre = map.get(course);
34        if (pre == null) {
35            status[course] = 2;
36            return true;
37
38        }
39        for (int p : pre ) {
40            if (!dfs(p, map, status)) {
41                return false;
42            }
43        }
44
45        status[course] = 2;
46        return true;
47
48
49    }
50}
51
52/**
531 -> 0
54
553 status
560 not take
571 in process
582 finished
59
60course -> prerequisites 
61判断所有课程的prere 有没有完成
62
63
64
65 */