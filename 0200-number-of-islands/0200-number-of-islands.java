class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static void dfs(int i , int j , int n , int m , char[][] mat , boolean[][] vis){
        if(i <0 || i>=n||j<0 || j>= m || mat[i][j] == '0' || vis[i][j] ) return;
        vis[i][j] =true;
        for(int k = 0 ; k < 4;k++){
           
                int tempI = i+dx[k];
                int tempY = j+dy[k];
                dfs(tempI,tempY,n,m,mat,vis);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] vis=new boolean[n][m];
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i,j,n,m,grid,vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}