class Solution {
    private int f(int n) {
        int ans = 0;

        while (n > 0) {
            ans += (n % 10) * (n % 10);
            n = n / 10;
        }

        return ans;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }

            set.add(n);
            n = f(n);
        }

        return true;
    }
}