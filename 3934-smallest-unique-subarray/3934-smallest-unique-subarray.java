class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length,l =1,r=n,ans=n;
        long m1 = 1_000_000_007l,m2 = 1_000_000_009l,b1=1_000_003l,b2=1_000_033l;
        long[] p1 = new long[n+1] , p2 = new long[n+1];
        p1[0] = p2[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            p1[i] = p1[i-1]*b1%m1;
            p2[i] = p2[i-1]*b2%m2;
        }
        while(l<=r){
            int mid = (l+r) >>1;
            if(f(nums,mid,p1,p2,b1,b2,m1,m2)){
                ans = mid ;
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return ans;
        
    }

    boolean f(int[] a , int k , long[] p1, long[] p2 , long b1 , long b2 , long m1 , long m2){
        int n = a.length;
        long h1 = 0,h2 = 0;
        for(int i = 0 ; i < k ;i++){
            h1 = (h1 * b1 + a[i]) % m1;
            h2 = (h2 * b2+a[i]) %m2;
        }
        Map<Long , Integer> mp = new HashMap<>();
        mp.put((h1<<32)^h2,1);
        for(int i=k ; i < n ; i++){
            h1 = (h1 - a[i-k]*p1[k-1]%m1+m1) %m1;
            h2 = (h2 - a[i-k]*p2[k-1]%m2+m2) %m2;
            h1 = (h1*b1 + a[i])%m1;
            h2 = (h2 *b2+a[i])%m2;
            long x = (h1 << 32)^h2;
            mp.put(x,mp.getOrDefault(x,0)+1);
            
        }
        for(int v : mp.values()) if( v== 1) return true;
        return false;
    }
}