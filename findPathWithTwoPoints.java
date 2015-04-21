package round2;

public class findPathWithTwoPoints {
	public boolean checkPath(int[][] arr, Point p1, Point p2) {
        if (p1 == null || p2 == null) {
            return false;
        }
        
        int x = p1.x;
        int y = p1.y;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        dfs(arr, x, y, visited);
        if (visited[p2.x][p2.y]) {
        	System.out.println("has path");
            return true;
            
        } else {
        	System.out.println("no path");
            return false;          
        }
        
    }
    
    public void dfs(int[][] arr, int x, int y, boolean[][] visited) {
        if (x >= arr.length || x < 0 || y >= arr[0].length || y < 0 || visited[x][y] || arr[x][y] == 1){
               return ;
        }
        visited[x][y] = true;
        dfs(arr, x - 1, y, visited);
        dfs(arr, x, y - 1, visited);
        dfs(arr, x + 1, y, visited);
        dfs(arr, x, y + 1, visited);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(0, 0);
		Point p2 = new Point(2, 3);
		findPathWithTwoPoints test = new findPathWithTwoPoints();
		int[][] arr =  {{0, 0, 1, 0, 0},
						{0, 0, 1, 0, 1},
						{0, 0, 1, 0, 0},
						{0, 0, 0, 0, 1},
						{0, 0, 0, 0, 0}};
		test.checkPath(arr, p1, p2);
		
	}

}



class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
