package com.alg1;

import java.util.Arrays;
import java.util.LinkedList;

public class findShortestDistanceBetweenDoor
{
	public void gameplay(int a[][])
	{
		int m = a.length - 1;
		int n = a[0].length - 1;
		LinkedList<pointnode> queue = new LinkedList<pointnode>();
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (a[i][j] == -2)
				{
					pointnode p = new pointnode(i, j);
					queue.add(p); 
				}
			}
		}
		while (!queue.isEmpty())
		{
			pointnode d = queue.remove();
			LinkedList<pointnode> queue2 = new LinkedList<pointnode>();
			queue2.add(d);
			while (!queue2.isEmpty())
			{
				pointnode current = queue2.remove();
				int dist = a[current.a][current.b];
				if (dist <= 0)  {
					dist = 0;
				}
				// move up
				if (current.a > 0 && a[current.a - 1][current.b] >= 0)
				{
					if (a[current.a - 1][current.b] == 0
							|| dist < a[current.a - 1][current.b])
					{
						a[current.a - 1][current.b] = dist + 1;
						queue2.add(new pointnode(current.a - 1, current.b));
					}
				}
				// move left
				if (current.b > 0 && a[current.a][current.b - 1] >= 0)
				{
					if (a[current.a][current.b - 1] == 0
							|| dist < a[current.a][current.b - 1])
					{
						a[current.a][current.b - 1] = dist + 1;
						queue2.add(new pointnode(current.a, current.b - 1));
					}
				}
				// move down
				if (current.a < m && a[current.a + 1][current.b] >= 0)
				{
					if (a[current.a + 1][current.b] == 0
							|| dist < a[current.a + 1][current.b])
					{
						a[current.a + 1][current.b] = dist + 1;
						queue2.add(new pointnode(current.a + 1, current.b));
					}
				}
				// move right
				if (current.b < n && a[current.a][current.b + 1] >= 0)
				{
					if (a[current.a][current.b + 1] == 0
							|| dist < a[current.a][current.b + 1])
					{
						a[current.a][current.b + 1] = dist + 1;
						queue2.add(new pointnode(current.a, current.b + 1));
					}
				}
				dist++;
			}
		}
	}
	
	public class pointnode {
		public int a;
		public int b;
		public pointnode(int x, int y) {
			this.a = x;
			this.b = y;
		}
	}
	
	public static void main(String[] args)
	{
		int a[][] =
			{
				{ 0, 0,-3,-2, 0 },
				{-3,-2, 0, 0, 0 },
				{ 0, 0,-3, 0, 0 },
				{-3,-3, 0,-2, 0 },
				{ 0,-3, 0, 0,-2 }
			};
		findShortestDistanceBetweenDoor test = new findShortestDistanceBetweenDoor();
		test.gameplay(a);
		System.out.println();
		for (int d[] : a)
		{
			System.out.println(Arrays.toString(d));
		}
	}
}
