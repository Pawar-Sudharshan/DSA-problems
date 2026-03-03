class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder();
        s.append('0');
        for (int i = 2; i <= n && s.length() < k; i++) {
            StringBuilder t = new StringBuilder(s);
            invert(t);                   
            t.reverse();                 
            s.append('1').append(t);     
        }
        return s.charAt(k - 1);         
    }

    private void invert(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, c == '0' ? '1' : '0');
        }
    }
}
