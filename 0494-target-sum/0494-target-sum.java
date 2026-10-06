class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // int[][] dp = new int[nums.length+1][target+1];
        // for(int[] a : dp) Arrays.fill(a,-1);
        Map<String,Integer> dp = new HashMap<>();
        return f(nums,0,target,dp);
    }
    private static int f(int a[], int i , int k ,Map<String,Integer> dp){
        if(a.length == i && k== 0) return 1;
        if(a.length == i) return 0;
        String key = i+","+k;
        if(dp.containsKey(key)) return dp.get(key);
        int add = f(a,i+1,k+a[i],dp);
        int sub = f(a,i+1,k-a[i],dp);
        dp.put(key,add+sub);
        return dp.get(key);
    }
}