public class Solution {
    private row = 0;
    private col = 0;
    
    public void fillBlack(int[][] a, int x, int y) {
        if (a == null) {
            return;
        }
        
        row = a.length;
        col = a[0].length;
        dfs(a, x, y);
    }
    
    public void dfs(int[][] a, int i, int j) {.
        if (i < 0 || i >= row || j < 0 || j >= col || a[i][j] != 0) {
            return;
        }. 
        a[i][j] = 1;
        dfs(a, i - 1, j);
        dfs(a, i + 1, j);
        dfs(a, i, j + 1);
        dfs(a, i, j - 1);
     
    }   
}


//求岛问题

public class SolutionDFS {
    
    private int row;
    private int col;   
 
    public int solve(int[][] a) {
        this.row = a.length;
        this.col = a[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 1) {
                    dfs(a, i, j); 
                    ans++;
                }
            }
        }
        
        return ans;
    }
    private void dfs(int[][] a, int i, int j){
        if (i < 0 || i >= row || j < 0 || j >= col || a[i][j] != 1) {
            return;
        }
        a[i][j] = 2;
        dfs(a, i + 1, j);
        dfs(a, i, j + 1);
        dfs(a, i - 1, j);
        dfs(a, i, j - 1);
    }
}