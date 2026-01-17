import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 1. Make key = sorted version of s
            char[] ch = s.toCharArray();
            Arrays.sort(ch);          // sorts characters
            String key = new String(ch);

            // 2. If key not present, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // 3. Add original string under this key
            map.get(key).add(s);
        }

        // 4. Final result = all grouped lists
        return new ArrayList<>(map.values());
    }
}
