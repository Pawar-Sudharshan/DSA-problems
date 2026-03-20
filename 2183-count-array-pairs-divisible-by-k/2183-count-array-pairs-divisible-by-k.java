class Solution {
    static int gcd(int a , int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public long countPairs(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            int g = gcd(x,k);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if(((long)g*key)%k ==0 ){
                    ans += val;
                }
            }
            map.put(g,map.getOrDefault(g,0)+1);
        } 
        return ans;
    }
}