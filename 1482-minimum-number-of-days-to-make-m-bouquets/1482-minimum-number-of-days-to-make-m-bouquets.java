class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long need = (long)m * k;
        if (need > n) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : bloomDay) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int left = min;
        int right = max;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int bouquets = countBouquets(bloomDay, mid, k);

            if (bouquets >= m) {
                ans = mid;          
                right = mid - 1;
            } else {
                left = mid + 1;     
            }
        }

        return ans;
    }

    private int countBouquets(int[] arr, int day, int k) {
        int bouquets = 0;
        int consecutive = 0;

        for (int val : arr) {
            if (val <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0; 
                }
            } else {
                consecutive = 0;      
            }
        }

        return bouquets;
    }
}