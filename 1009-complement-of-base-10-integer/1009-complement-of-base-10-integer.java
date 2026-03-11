class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        String str = Integer.toBinaryString(n);
        StringBuilder newstr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') newstr.append('0');
            else newstr.append('1');
        }
        return Integer.parseInt(newstr.toString(), 2);
    }
}
