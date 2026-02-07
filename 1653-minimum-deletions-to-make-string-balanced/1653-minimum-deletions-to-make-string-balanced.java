class Solution {
    public int minimumDeletions(String s) {
        int deletions = 0; 
        int bCount = 0;  

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                bCount++;
            } else { 
                deletions = Math.min(deletions + 1, bCount);
            }
        }

        return deletions;
    }
}
