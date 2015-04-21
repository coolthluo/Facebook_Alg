package com.alg1;

import java.util.Arrays;
import java.util.LinkedList;

public class findShortestDistanceBetweenDoorString {
	public int[][] gameplay(String a[][]) {
		int m = a.length;
		int n = a[0].length;
		LinkedList<pointnode> queue = new LinkedList<pointnode>();
		int[][] sol = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == "G") {
					pointnode p = new pointnode(i, j);
					queue.add(p);
					sol[i][j] = -2;
				} else if (a[i][j] == "W") {
					sol[i][j] = -3;
				}
			}
		}
		while (!queue.isEmpty()) {
			pointnode d = queue.remove();
			LinkedList<pointnode> queue2 = new LinkedList<pointnode>();
			queue2.add(d);
			while (!queue2.isEmpty()) {
				pointnode current = queue2.remove();
				int dist = sol[current.a][current.b];
				if (dist <= 0) {
					dist = 0;
				}
				// move up
				if (current.a > 0 && sol[current.a - 1][current.b] >= 0) {
					if (sol[current.a - 1][current.b] == 0 || dist < sol[current.a - 1][current.b]) {
						sol[current.a - 1][current.b] = dist + 1;
						queue2.add(new pointnode(current.a - 1, current.b));
					}
				}
				// move left
				if (current.b > 0 && sol[current.a][current.b - 1] >= 0) {
					if (sol[current.a][current.b - 1] == 0 || dist < sol[current.a][current.b - 1]) {
						sol[current.a][current.b - 1] = dist + 1;
						queue2.add(new pointnode(current.a, current.b - 1));
					}
				}
				// move down
				if (current.a < m - 1 && sol[current.a + 1][current.b] >= 0) {
					if (sol[current.a + 1][current.b] == 0 || dist < sol[current.a + 1][current.b]) {
						sol[current.a + 1][current.b] = dist + 1;
						queue2.add(new pointnode(current.a + 1, current.b));
					}
				}
				// move right
				if (current.b < n - 1 && sol[current.a][current.b + 1] >= 0) {
					if (sol[current.a][current.b + 1] == 0 || dist < sol[current.a][current.b + 1]) {
						sol[current.a][current.b + 1] = dist + 1;
						queue2.add(new pointnode(current.a, current.b + 1));
					}
				}
				dist++;
			}
		}
		return sol;
	}

	public class pointnode {
		public int a;
		public int b;

		public pointnode(int x, int y) {
			this.a = x;
			this.b = y;
		}
	}

	public static void main(String[] args) {
		String a[][] = { { "", "", "W", "G", "" }, { "W", "G", "", "", "" },
				{ "", "", "W", "", "" }, { "W", "W", "", "G", "" },
				{ "", "W", "", "", "G" } };
//		String a[][] = { {"", "W", "G"}, {"", "G",""},{"W","",""}	
//		};
		findShortestDistanceBetweenDoorString test = new findShortestDistanceBetweenDoorString();
		int[][] res = test.gameplay(a);
		System.out.println();
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				if (res[i][j] == -3) {
					res[i][j] = 0;
				}
			}
		}
		for (int d[] : res) {
			System.out.println(Arrays.toString(d));
		}
	}
}
