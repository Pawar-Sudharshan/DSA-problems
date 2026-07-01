class Solution {
    public int maxDepth(String s) {
        int max =0 ;
        int cnt =0 ;
        int n = s.length();
        for(int i = 0 ; i < n ;i++){
            if(s.charAt(i)=='(') cnt++;
            if(s.charAt(i) == ')') cnt--;
            max = Math.max(max,cnt);
        }
        return max;
    }
}