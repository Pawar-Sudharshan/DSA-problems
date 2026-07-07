class Solution {
    public long sumAndMultiply(int n) {
        String num = String.valueOf(n).replace("0","");
        if(num.isEmpty()) return 0;
        long sum =0;
        for(char ch : num.toCharArray()) sum+=ch-'0';
        long ans = Long.parseLong(num) * sum;
        return ans;
    
    }
}