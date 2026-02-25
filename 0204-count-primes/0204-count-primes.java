class Solution {
    public int countPrimes(int n) {
        if(n == 1 || n == 0 || n < 0) return 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        prime[0] =prime[1] = false;
        for(int i =2 ;i*i < n ;i++){
            if(prime[i] ){
                for(int j = i*i;j<n;j += i){
                    prime[j] = false;
                }
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < n ;i++){
            if(prime[i]) cnt++;
        }
        return cnt;
    }
}