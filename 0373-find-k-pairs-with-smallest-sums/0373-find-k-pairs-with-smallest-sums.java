class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        List<List<Integer>> ans = new ArrayList<>();

        pq.add(new int[]{0, 0});

        while (!pq.isEmpty() && ans.size() < k) {
            int[] idx = pq.poll();
            int i = idx[0];
            int j = idx[1];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                pq.add(new int[]{i, j + 1});
            }

            if (j == 0 && i + 1 < nums1.length) {
                pq.add(new int[]{i + 1, 0});
            }
        }

        return ans;
    }
}