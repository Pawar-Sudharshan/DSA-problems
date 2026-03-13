class Solution {
     private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {
        long total = 0;

        for (int t : workerTimes) {

            // Solve: t * x(x+1)/2 <= time
            long val = (long) (Math.sqrt(1 + 8.0 * time / t) - 1) / 2;

            total += val;

            if (total >= mountainHeight)
                return true;
        }

        return false;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = (long)1e18;
        while(left < right){
            long mid = (right - left)/2 + left; 
            if(canFinish(mid ,mountainHeight,workerTimes)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}