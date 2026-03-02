class Solution {
    public int minPartitions(String n) {
       int ans = 0;
       for(int i = 0 ; i < n.length();i++  ) {
        int num = n.charAt(i)-'0';
        ans =Math.max(ans,num);
       }
       return ans;
    }
}