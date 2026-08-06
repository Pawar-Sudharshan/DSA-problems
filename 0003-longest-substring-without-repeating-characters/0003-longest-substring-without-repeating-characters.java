class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       int left =0;
       int ans =0 ;
       Set<Character> set = new HashSet<>();
       for(int right = 0 ; right < n ; right++){
           char rh  = s.charAt(right);
           while(set.contains(rh)){
            char lt = s.charAt(left);
            set.remove(lt);
            left++;
           }
           set.add(rh);
           ans = Math.max(ans , set.size());
       }
       return ans;
    }
}
