class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);   // max pile size
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2; // current speed k
            long hours = 0;

            // compute total hours needed with speed = mid
            for (int p : piles) {
                // ceil(p / mid) without using double
                hours += (p + mid - 1) / mid;
            }

            if (hours <= h) {
                // can finish in time, try smaller speed
                ans = mid;
                right = mid - 1;
            } else {
                // need more speed
                left = mid + 1;
            }
        }

        return ans;
    }
}
