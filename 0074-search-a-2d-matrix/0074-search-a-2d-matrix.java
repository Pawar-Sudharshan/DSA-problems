class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        // int n = mat.length;
        // int m = mat[0].length;
        for(int[] list : mat){
            for(int x : list){
                if(x == target) return true;
            }
        }
        return false;
    }
}