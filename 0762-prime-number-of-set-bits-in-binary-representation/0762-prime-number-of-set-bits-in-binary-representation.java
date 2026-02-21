class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] prime = new boolean[32];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        for(int i = 2; i < 32; i++){
            if(prime[i]){
                for(int j = i*i; j < 32; j += i){
                    prime[j] = false;
                }
            }
        }
        
        int ans = 0;
        for(int i = left; i <= right; i++){
            int cnt = Integer.bitCount(i);
            if(prime[cnt]) ans++;
        }
        return ans;
    }
}
