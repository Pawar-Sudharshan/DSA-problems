class Solution {
    private static int gcd(int a , int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            min = Math.min(i,min);
            max = Math.max(i , max);
        }
        return gcd(min,max);
    }
}