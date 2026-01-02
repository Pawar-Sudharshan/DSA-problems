class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sumApple = 0;
        for (int x : apple) sumApple += x;

        Arrays.sort(capacity); // ascending
        int boxes = 0, sumCap = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            sumCap += capacity[i];
            boxes++;
            if (sumCap >= sumApple) break;
        }

        return boxes;
    }
}
