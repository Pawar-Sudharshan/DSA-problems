class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[k+1];
        int idx = 0;
        int num = 1;
        for(int i = 1 ; i <=k ;i++){
            while(idx < n && arr[idx]==num){
                num++;
                idx++;
            }
            ans[i] = num;
            num++;
        }
        return ans[k];
    }
}