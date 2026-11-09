class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max= 0;
        int i = 0 ; 
        int j = n-1;
        while(i<j){
            int h = Math.min(height[i],height[j]);
            int w = j-i;
            max = Math.max(max,h*w);
            if(height[i] > height[j]) j--;
            else i++;
        }
        return max;
        
    }
}