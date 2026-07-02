class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> ans = new HashSet<>();
        helper(1, 0, new ArrayList<Integer>(), ans, k, n);
        return new ArrayList<>(ans);
    }

    static void helper(int x, int sum, List<Integer> list, Set<List<Integer>> ans, int k, int n) {
        if (list.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(list)); 
                return;
            }
            return;
        }
        if (x > 9) return;

        // include x
        sum += x;
        list.add(x);
        helper(x + 1, sum, list, ans, k, n);

        // backtrack
        sum -= x;
        list.remove(list.size() - 1);

        // exclude x
        helper(x + 1, sum, list, ans, k, n);
    }
}