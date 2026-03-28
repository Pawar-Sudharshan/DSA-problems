class Solution {
    static boolean isValid(int[] count){
        return (count[0]>0 && count[1]>0 && count[2]>0);
    }
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int ans = 0 ;
        int left = 0 ;
        for(int right = 0 ; right < s.length();right++){
            int idx = s.charAt(right)-'a';
            count[idx]++;
            while(isValid(count)){
                ans += s.length()-right;
                int prev = s.charAt(left)-'a';
                count[prev]--;
                left++;
            }
        }
        return ans;
    }
}