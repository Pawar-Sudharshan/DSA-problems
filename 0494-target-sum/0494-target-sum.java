class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return f(nums,0,target);
    }
    private static int f(int a[], int i , int k){
        if(a.length == i && k== 0) return 1;
        if(a.length == i) return 0;
        int add = f(a,i+1,k+a[i]);
        int sub = f(a,i+1,k-a[i]);
        return add+sub;
    }
}