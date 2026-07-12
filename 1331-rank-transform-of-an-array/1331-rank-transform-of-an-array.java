import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] rank = new int[n];

        List<Integer> mid = new ArrayList<>();
        for (int x : arr) {
            mid.add(x);
        }
        Collections.sort(mid);  
        Map<Integer, Integer> valueToRank = new HashMap<>();
        int currentRank = 1;
        for (int val : mid) {
            if (!valueToRank.containsKey(val)) {
                valueToRank.put(val, currentRank);
                currentRank++;
            }
        }
        for (int i = 0; i < n; i++) {
            rank[i] = valueToRank.get(arr[i]);
        }

        return rank;
    }
}