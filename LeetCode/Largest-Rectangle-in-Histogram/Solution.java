1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        int n = heights.length;
4        // 1. 增加哨兵节点，简化边界处理
5        int[] newHeights = new int[n + 2];
6        for (int i = 0; i < n; i++) newHeights[i + 1] = heights[i];
7        
8        Deque<Integer> stack = new ArrayDeque<>();
9        int maxArea = 0;
10        
11        for (int i = 0; i < newHeights.length; i++) {
12            // 2. 当遇到当前高度比栈顶矮时，触发计算
13            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
14                int curHeight = newHeights[stack.pop()]; // 确定高度
15                int rightBoundary = i;                   // 右边界
16                int leftBoundary = stack.peek();        // 左边界（新的栈顶）
17                
18                int width = rightBoundary - leftBoundary - 1;
19                maxArea = Math.max(maxArea, curHeight * width);
20            }
21            stack.push(i);
22        }
23        return maxArea;
24    }
25}