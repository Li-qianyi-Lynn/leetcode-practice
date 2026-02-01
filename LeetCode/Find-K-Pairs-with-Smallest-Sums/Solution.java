1class Solution {
2    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
3        int len = Math.min(nums1.length,k);
4        List<List<Integer>> res = new ArrayList<>();
5        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0])); // minHeap
6
7        for (int i = 0; i < len; i++) {
8            int sum = nums1[i] + nums2[0];
9            int[] cur = new int[]{sum, i, 0};
10            pq.offer(cur);
11        }
12        
13        while (k > 0 && !pq.isEmpty()) {
14            int[] temp = pq.poll();
15            int indx1 = temp[1];
16            int indx2 = temp[2];
17            res.add(Arrays.asList(nums1[indx1], nums2[indx2]));
18        
19
20            if (nums2.length-1 > indx2) {
21                pq.offer(new int[]{nums1[indx1] + nums2[indx2+1], indx1, indx2+1});
22            }
23            k--;
24        }
25        return res;
26    }
27}
28
29/**
30pq: k 
31
32int[]: sum, i, j
33把 len int[] 放进pq minHeap
34Integer.compare
35
36while (k > 0 && minheap!= null )
37peak poll， 加到res
38看nums2[j+1] 还有没有，有的话加入pq，继续比较
39k--;
40
41
42 */