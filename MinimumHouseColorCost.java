/*
 * There are a row of houses (n), each house can be painted with j . 
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color. 
 * You have to paint the houses with minimum cost. 
 */

/*
	方法是用DP做，维护一个n*m的数组res，res[i][j]表示刷到第i个房子时，用第j种颜料的话的最低cost。
	因为对于每一种颜色，都要逐一查看上一个房子里除这个颜色外的所有颜色花费，选出最低，时间O(m^2*n)，空间O(n*m)

Follow up自然是改进，使用O(m)的空间和O(nm)的时间。
	提高空间很简单，可以注意到只需要上个房子的结果，因此可以只用一维数组。
	提高时间的方法是这样的：
		在计算n-1个房子的所有颜色cost时，就维护记录cost最小的前两种颜色。
		这样针对第n个房子的每个颜色，不用观察n-1的m-1个颜色，而是只要基于n-1时cost最小的那种颜色计算新的cost就行。
		如果是同一种颜色，就基于cost第二小的颜色。
*/
public class HouseMinimumCostOfPainting {
	public int minCost(int n, int m, int[][] cost) {
		//res[i][j] means 前i个house都paint了且第i个house paint成 第j种color的最小cost
		//res[i][j] means in front of i houses were painted,and the i house was painted to j color,the minimum cost
		int[][] res = new int[n + 1][m];
		//since the house amount is zero, so all the cost equals zero
		for (int i = 0; i < m; i++) {
			res[0][i] = 0;
		}
		//initialize the minimum cost to MAX_VALUE
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < m; k++) {
					//in the i - 1 house, we try all the colors k, and the color k do not equals j, to find the minimum cost
					if (k != j) {
						res[i][j] = Math.min(res[i][j], res[i - 1][k] + cost[i - 1][j]);
					}
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			result = Math.min(result, res[n][i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
