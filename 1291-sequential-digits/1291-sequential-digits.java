class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int[] a = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};
        for(int x : a){
            if(low <= x && x <= high) ans.add(x);
        }
        return ans;
    }
    private boolean valid(int x){
        String s = String.valueOf(x);
        int n = s.length();
        for(int i = 0 ; i < n-1 ;i++){
            if(s.charAt(i)-'0' != (s.charAt(i+1)-'0' -1)) return false;
        }
        return true;
    }
}