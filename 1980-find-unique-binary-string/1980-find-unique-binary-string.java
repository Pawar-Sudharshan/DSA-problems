class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] ans = new char[n];
        for(int i = 0 ; i < n ;i++){
            char c = nums[i].charAt(i);
            ans[i] = (c=='0')?'1':'0';
        }
        return new String(ans);
    }
}