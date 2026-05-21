class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort by right endpoint (second element)
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int res = 1;           // at least one pair forms a chain
        int lastEnd = pairs[0][1]; // right value of last selected pair

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) { // b < c condition
                res++;
                lastEnd = pairs[i][1];
            }
        }

        return res;
    }
}