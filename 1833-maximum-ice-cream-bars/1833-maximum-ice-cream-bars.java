class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for(int x : costs){
            if(x <= coins){
               ans++;
                coins -= x;
            }else{
                break;
            }
        }
        return ans;
    }
}