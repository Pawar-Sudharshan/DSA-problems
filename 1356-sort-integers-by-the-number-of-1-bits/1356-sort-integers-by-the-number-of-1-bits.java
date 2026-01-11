class Solution {
    private int countBits(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt;
        // or: return Integer.bitCount(n);
    }

    public int[] sortByBits(int[] arr) {
        // key: count of set bits, value: all numbers with that count
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int x : arr) {
            int bits = countBits(x);
            map.computeIfAbsent(bits, k -> new ArrayList<>()).add(x);
        }

        // for same bit-count, sort by value
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // flatten back to array
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            for (int v : e.getValue()) {
                arr[i++] = v;
            }
        }
        return arr;
    }
}
