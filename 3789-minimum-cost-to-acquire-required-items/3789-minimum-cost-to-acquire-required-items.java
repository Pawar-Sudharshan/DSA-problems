class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long lum = (long)cost1 + (long)cost2+costBoth + (long)need1+need2;
           if((long)costBoth >= (long)cost1 + (long)cost2){
               return (long)need1*cost1 + (long)need2*cost2;
           }

        int max = Math.max(need1 ,need2);
        long ans = Long.MAX_VALUE;
        long[] ks = {0l,need1,need2,Math.min(need1,need2),max};
        for(long k0 : ks){
            long k = Math.max(0l , Math.min(max,k0));
            long r1 = Math.max(0l , need1-k);
            long r2 = Math.max(0,need2-k);
            long cost = k * costBoth +r1*cost1 + r2 *cost2;
            ans = Math.min(ans,cost);
        }
        return ans;
    }
}