class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0 ; i < n ; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) return -1;

        int start = 0 , curr = 0;
        for(int i = 0 ; i < n ; i++){
            curr += gas[i] - cost[i];
            if(curr < 0){
                start = i+1;
                curr = 0;
            }
        }
        return start;
    }
}