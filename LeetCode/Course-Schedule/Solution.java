1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        // edge case
4        if (prerequisites.length == 0) {
5            return true;
6        }
7
8        int[] indegree = new int[numCourses]; //  how many prerequists
9        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
10        for (int[] pres : prerequisites) {
11            int pre = pres[1];
12            int course = pres[0];
13            indegree[course]++;
14            map.putIfAbsent(pre, new ArrayList<>());
15            map.get(pre).add(course);
16        }
17        int finished = 0;
18        Deque<Integer> dq = new ArrayDeque<>();
19        for (int i = 0; i < numCourses; i++) {
20            if (indegree[i] == 0) {
21                finished ++;
22                dq.offerLast(i);
23            }
24
25        }
26
27        while (!dq.isEmpty()) {
28            int cur = dq.pollFirst();
29            if (map.containsKey(cur)) {
30                List<Integer> list = map.get(cur);
31                for (int i = 0; i < list.size(); i++ ) {
32                    int processedCourse = list.get(i);
33                    indegree[processedCourse]--;
34                    if (indegree[processedCourse] == 0) {
35                        finished ++;
36                        dq.offerLast(processedCourse);
37                    }
38                }
39            }
40        }
41        return finished == numCourses;
42
43
44        
45    }
46}
47
48/**
49indegree table: each course has how many prerequists
50map: precourse -> unlocked courses Integer -> List<Integer>
51int finished coures
52
53if all precourses of this course finished, add the course id to the dq 
54dq: take this course as the precourse, check which course can be processed , add it to the dq
55
56
57
58
59return finished == numcourse
60
61 */