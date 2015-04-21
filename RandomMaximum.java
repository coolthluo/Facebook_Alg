package round2;

import java.util.Random;

/*
 * 给你一个array，返回array里面最大数字的index，但是必须是最大数字里面随机的一个index。
 * 比如[2,1,2,1,5,4,5,5]必须返回[4,6,7]中的随机的一个数字，要求O(1)space。
 */
public class RandomMaximum {
	
	
	//time complexity: O(n)
	public int randomMax(int[] nums) {
		//res is the return result's index
		int res = 0;
		//count use to 
		int count = 0;
		//record the max value
		int max = Integer.MIN_VALUE;
		//generate the random integer
		Random rand = new Random();
		//traverse the array
		for (int i = 0; i < nums.length; i++) {
			//if find value larger than max, that assigned to max
			if (nums[i] > max) {
				max = nums[i];
				count = 1;//once find max,reset the count to 1
				res = i;//res store the index of max value
			} else if (nums[i] == max) { //if find multiple max value
				//use random function to create the random value,
				if ((rand.nextInt() % ++count) == 0) {
					res = i;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomMaximum test = new RandomMaximum();
		int[] nums = {2, 1, 2, 1, 5, 4, 5, 5, 5};
		System.out.println(test.randomMax(nums));
	}

}
