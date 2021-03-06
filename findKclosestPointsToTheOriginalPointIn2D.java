package round2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class findKclosestPointsToTheOriginalPointIn2D {

	//Solution1 : use quick select, O(n)
	public ArrayList<Point> getClosetPoints(ArrayList<Point> points, int k) {
		ArrayList<Point> res = new ArrayList<Point>();
		if (k > points.size()) {
			return res;
		}
		partition(k, points, 0, points.size() - 1);
		// for (int i = 0; i < k; i++) {
		// 	res.add(points.get(i));
		// }
		res = points.subList(0, k);
		return res;
	}
	
	public void partition(int k, ArrayList<Point> points, int start, int end) {
		int l = start;
		int r = end;
		int pivot = end;
		while (true) {
			while (points.get(l).dist < points.get(pivot).dist && l < r) {
				l++;
			}
			while (points.get(r).dist >= points.get(pivot).dist && l < r) {
				r--;
			}
			if (l == r) {
				break;
			}
			swap(points, l, r);
		}
		swap(points, l, end);
		if (l + 1 == k) {
			return;
		} else if (l + 1 < k) {
			partition(k, points, l + 1, end);
		} else {
			partition(k, points, start, l - 1);
		}
	}
	
	public void swap(ArrayList<Point> points, int l, int r) {
		Point temp = points.get(l);
		points.set(l, points.get(r));
		points.set(r, temp);
	}

	//solutiton 2 : use MaxHeap
	public PriorityQueue getClosetPoints(ArrayList<Point> points, int k) {
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k);
		
		for (Point point : points) {
			//if size < k, means still have place to store the point, all the point in the queue
			//is in the front of K closet point.
			if (queue.size() < k) {
				queue.offer(point);
			} else {
				//queue.peek() is the maximum elements,
				//every time when the size is full, we only need to compare the new point to the
				//peek point, cause it is the maximum value, if new point is smaller than peek()
				//just poll the peek point, and offer new point
				if (queue.peek().compareTo(point) < 0) {
					queue.poll();
					queue.offer(point);
				}
			}
		}
		return queue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Point> points = new ArrayList<Point>();
        Point origin = new Point(4, 0);
        points.add(new Point(1, 0, origin));
        points.add(new Point(2, 3, origin));
        points.add(new Point(3, 2, origin));
        points.add(new Point(4, 0, origin));
        points.add(new Point(1, 1, origin));
        points.add(new Point(2, 2, origin));
        points.add(new Point(-1, 0, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(1, 1, origin));
        findKclosestPointsToTheOriginalPointIn2D test = new findKclosestPointsToTheOriginalPointIn2D();
        
//        PriorityQueue c = test.getClosetPoints(points, 4); MaxHeap method

        // ArrayList<Point> res = test.getClosetPoints(points, 3);
        // for (Point p : res) {
        // 	System.out.print(p.toString());
        // }
        
	}

}

class Point implements Comparable<Point> {
	int x;
	int y;
	double dist;
	public Point(int x, int y, Point originPoint) {
		this.x = x;
		this.y = y;
		this.dist = Math.hypot(this.x - originPoint.x, this.y - originPoint.y);
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point thatPoint) {
		//negative less than
		//zero equals
		//positive greater than
		
		//配合上compareTo(point) < 0，是最小堆  peek() compareTo newpoint, peek()是最小值
		//用最小堆做找前K个最大值，因为每次只用和最小值比较，只要大于最小值就入队列
		
		//配合上compareTo(point) < 0, 是最大堆 newpoint compareTo peek(), peek()是最大值
		//用最大堆做找前K个最小值， 因为每次只用和最大值比较，只要小于最大值就入队列
		
		//生成最大堆使用o2-o1,生成最小堆使用o1-o2, 并修改 e.compareTo(peek) 
		return Double.valueOf(thatPoint.dist).compareTo(dist);
	
	}
	@Override
	public String toString() {
		return "x: " + x + " y: " + y + " ";
	}
}
