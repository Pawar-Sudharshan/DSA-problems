class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt = 0;
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        Arrays.fill(lower,false);
        Arrays.fill(upper,false);
        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                lower[ch-'a'] = true;
            }else{
                upper[ch-'A'] = true;
            }
        }
        for(int i = 0 ; i < 26;i++){
            if(lower[i] &&  upper[i]) cnt++;
        }
        return cnt;
    }
}