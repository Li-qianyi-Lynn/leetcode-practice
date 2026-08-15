1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        Deque<Integer> dq = new ArrayDeque<>(); //stack[ decreasing]
5        for (int num : nums2) {
6            while (!dq.isEmpty() && dq.peekLast() < num) {
7                map.put(dq.pollLast(), num);
8
9            }
10            dq.offerLast(num);
11        }
12        int[] res = new int[nums1.length];
13        for (int i = 0; i < nums1.length; i++) {
14            res[i] = map.getOrDefault(nums1[i], -1);
15
16        }
17        return res;
18        
19    }
20}
21/**
22monostack
23
24
25
26 */