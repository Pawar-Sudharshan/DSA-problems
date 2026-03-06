class Solution {
    public boolean checkOnesSegment(String s) {
      boolean seen = false;
      for(char ch :s.toCharArray()){
        if(ch == '0'){
            seen = true;
        }else{
            if(seen) return false;
        }
        
      }
      return true;
    }
}