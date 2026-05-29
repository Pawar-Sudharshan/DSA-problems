class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        int A = capacityA;
        int B = capacityB;
        
        while (left < right) {
            // Alice waters plant[left]
            if (plants[left] <= A) {
                A -= plants[left];
            } else {
                ans++;
                A = capacityA - plants[left];
            }
            left++;
            
            // Bob waters plant[right]
            if (plants[right] <= B) {
                B -= plants[right];
            } else {
                ans++;
                B = capacityB - plants[right];
            }
            right--;
        }
        
        // Handle the middle plant when left == right
        if (left == right) {
            if (A >= B) {
                // Alice waters it
                if (plants[left] > A) {
                    ans++;
                }
            } else {
                // Bob waters it
                if (plants[left] > B) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}