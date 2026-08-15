1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        int[] res = new int[nums1.length];
4        Map<Integer, Integer> map = new HashMap<>();
5
6        Deque<Integer> dq = new ArrayDeque<>(); // stack
7        for (int num : nums2) {
8            // 当前元素大于栈顶元素时，栈顶元素的下一个更大元素就是 num
9            while (!dq.isEmpty() && dq.peek() < num) {
10                map.put(dq.pop(), num);
11            }
12            dq.push(num);
13        }
14
15        for (int i = 0; i < nums1.length; i++) {
16            res[i] = map.getOrDefault(nums1[i], -1);
17        }
18
19        return res;
20
21        
22    }
23}