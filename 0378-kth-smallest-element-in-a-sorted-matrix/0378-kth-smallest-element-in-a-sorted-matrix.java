class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] a : matrix){
            for(int x : a){
                pq.add(x);
                if(pq.size()>k) pq.poll();
            }
        }
        // while(k>1){
        //     pq.poll();
        //     k--;
        // }
        return pq.peek();
    }
}