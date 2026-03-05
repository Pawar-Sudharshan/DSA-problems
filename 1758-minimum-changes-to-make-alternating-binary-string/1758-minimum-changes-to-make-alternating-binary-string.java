class Solution {
    public int minOperations(String s) {
        int n =s.length();
        StringBuffer first = new StringBuffer();
        StringBuffer second = new StringBuffer();
        for(int i = 1 ; i <=n;i++ ){
            // first = first<<1;
            if(i%2 == 1) first.append('1');
            else first.append('0');
        }
        for(int i = 1 ; i <=n;i++ ){
            if(i%2 == 0) second.append('1');
            else second.append('0');
        }
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 0 ; i < n ;i++){
            if(first.charAt(i)!=s.charAt(i)) ans1++;
            if(second.charAt(i) != s.charAt(i)) ans2++;
        }
        return Math.min(ans1,ans2);
    }
}