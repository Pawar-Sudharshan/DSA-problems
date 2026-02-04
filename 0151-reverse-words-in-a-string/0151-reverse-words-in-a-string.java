class Solution {
    public String reverseWords(String s) {
        // List<String> list =new ArrayList<>();
        StringBuffer ans = new StringBuffer();
        String arr[] =s.trim().split("\\s+");
        // for(String str : arr) ans.appendFirst(str);
        int n = arr.length;
        for(int i = n -1 ;i>=0;i--){
            ans.append(arr[i]);
            if(i>0) ans.append(" ");
        } 

        return ans.toString();
        
    }
}