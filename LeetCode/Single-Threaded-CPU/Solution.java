class Solution {
    private final static int ENQUEUE_TIME = 0;
    private final static int PROCESSING_TIME = 1;
    private final static int INDEX = 2;
    
    public int[] getOrder(int[][] tasks) {
        for(int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            tasks[i] = new int[]{task[ENQUEUE_TIME], task[PROCESSING_TIME], i};
        }
        
        Arrays.sort(tasks, (task1, task2) -> {
           return Integer.compare(task1[ENQUEUE_TIME], task2[ENQUEUE_TIME]); 
        });
        
        Queue<int[]> pq = new PriorityQueue<>((task1, task2) -> {
           if(task1[PROCESSING_TIME] == task2[PROCESSING_TIME])
               return Integer.compare(task1[INDEX], task2[INDEX]);
            
           return Integer.compare(task1[PROCESSING_TIME], task2[PROCESSING_TIME]); 
        });
        
        int currentTime = 0;
        int enqueueIndex = 0;
        int[] processingOrder = new int[tasks.length];
        int processedIndex = 0;
        while(!pq.isEmpty() || enqueueIndex < tasks.length) {
            if(pq.isEmpty()) {
                currentTime = Math.max(currentTime, tasks[enqueueIndex][ENQUEUE_TIME]);
            }
            
            while(enqueueIndex < tasks.length && tasks[enqueueIndex][ENQUEUE_TIME] <= currentTime) {
                pq.offer(tasks[enqueueIndex]);
                enqueueIndex++;
            }
            
            int[] task = pq.poll();
            currentTime += task[PROCESSING_TIME];
            processingOrder[processedIndex++] = task[INDEX];
        }
        
        return processingOrder;
    }
}