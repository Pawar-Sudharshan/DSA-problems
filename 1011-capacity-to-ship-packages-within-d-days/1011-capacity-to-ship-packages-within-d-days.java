class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum =0;
        int n = weights.length;
        int max = 0;
        for(int w : weights){
            max = Math.max(w,max);
             sum += w;
        }

        // for(int d =max ; d <= sum ;d++){
        //     int day = 1;
        //     int s = 0;
        //     for(int i = 0 ; i <n;i++ ){
        //         if(s+weights[i] <= d){
        //             s+= weights[i];
        //         }else{
        //             day++;
        //             s = weights[i];
        //         }
        //     }
        //     if(day <= days) return d;
        // }

        int left = max , right = sum , ans = sum;
        while(left<=right){
            int mid = left + (right - left)/2;
            int day = 1 ,  s = 0;
            for(int x : weights){
                if(s+x <= mid) {
                    s += x;
                }else{
                    day++;
                    s = x;
                }

            }
            if(day <= days){
                ans = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return ans;
    }
}