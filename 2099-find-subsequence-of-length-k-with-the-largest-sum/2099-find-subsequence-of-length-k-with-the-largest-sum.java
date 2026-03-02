class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new  PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int i = 0 ; i < n ;i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.size()>k){
                pq.poll();
            }
        }
        int j = 0;
        int[] idx = new int[k];
        while(!pq.isEmpty()){
            idx[j++] = pq.poll()[1];
        }
        
        Arrays.sort(idx);
        int res[] = new int[k];
        for(int i = 0 ; i < k ;i++){
            res[i] = nums[idx[i]];
        }
        return res;
    }
}