class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int p1 =0 ;
        int p2 = 0;
        StringBuilder ans = new StringBuilder();
        while(p1 < Math.min(n,m) && p2 < Math.min(n,m) ){
            ans.append(word1.charAt(p1++));
            ans.append(word2.charAt(p2++));
        }
        while(p1 < n){
            ans.append(word1.charAt(p1++));
        }
        while(p2 < m){
            ans.append(word2.charAt(p2++));
        }
        return ans.toString();
    }
}