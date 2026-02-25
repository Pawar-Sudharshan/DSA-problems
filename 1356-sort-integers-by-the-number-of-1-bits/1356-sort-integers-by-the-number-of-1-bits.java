class Solution {

    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int x : arr) {
            int bc = Integer.bitCount(x);
            List<Integer> list = map.getOrDefault(bc, new ArrayList<>());
            list.add(x);                
            map.put(bc, list);          
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int n = arr.length;
        int[] ans = new int[n];
        int idx = 0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int x : entry.getValue()) {
                ans[idx++] = x;
            }
        }

        return ans;
    }
}
