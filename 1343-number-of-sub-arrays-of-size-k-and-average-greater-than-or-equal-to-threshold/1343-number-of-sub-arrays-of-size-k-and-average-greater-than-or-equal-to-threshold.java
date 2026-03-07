class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int count = 0;
        if (sum >= (long) threshold * k) {
            count++;
        }
        for (int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            if (sum >= (long) threshold * k) {
                count++;
            }
        }
        return count;
    }
}
