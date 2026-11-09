class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "");
        if(cleaned.length() == 0) return true;
        return valid(cleaned.toLowerCase());
    }
    private static boolean valid(String s){
        int i = 0; 
        int j = s.length()-1;
        while(i<j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        return  (i>=j) ?  true :  false;
    }
}