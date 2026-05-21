class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort by second element (right endpoint) for greedy
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        ArrayList<int[]> chain = new ArrayList<>();
        int[] start = pairs[0];
        chain.add(start);

        for (int i = 1; i < pairs.length; i++) {
            if (start[1] < pairs[i][0]) {
                start = pairs[i];
                chain.add(start);
            }
        }

        return chain.size();
    }
}