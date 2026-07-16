class Solution {
    static int gcd(int a , int b){
        while(b!=0){
            int t = a%b;
            a =b ;
            b =t;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max[] = new int[n];
        max[0] = nums[0];
        for(int i = 1 ;i < n ;i++) max[i] = Math.max(max[i-1],nums[i]);
        int[] preGcd=new int[n];
        preGcd[0] = gcd(nums[0],max[0]);
        for(int i = 1 ; i < n ;i++){
            preGcd[i] = gcd(nums[i],max[i]);
        }
        long sum = 0;
        Arrays.sort(preGcd);
        int left = 0;
        int right =  n-1;
        while(left <right){
            sum += gcd(preGcd[left],preGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
}