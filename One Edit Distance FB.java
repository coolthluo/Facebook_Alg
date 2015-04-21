/*
	Facebook, if the distance between a and b is at most 1
	// return if the distance between a and b is at most 1.. 
	// Distance: minimum number of modifications to make a=b
	// Modification:
	//   1. change an int in a
	//   2. insert an int to a
	//   3. remove an int from a
*/

// class IntFileIterator {
//   boolean hasNext();
//   int next();
// }

// public class{
//   public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b)；

// }

/*
	这题就是one edit distance的变形题，难点在于给的Iterator，事先不知道两个file
	的长度，也不允许用extra space（所以不能转成两个string再比），那么一个个往前
	跑的时候就得三种情况都考虑。。。。
*/


public class Solution {
	class IntFileIterator {
		boolean hasNext();
		int next();
	}

	public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b) {
		return check(a, b, 0);
	}

	public boolean check(IntFileIterator a, IntFileIterator b, int distance) {
		IntFileIterator aa = new IntFileIterator(a); //copy of iterator a before next() fucntion
		IntFileIterator bb = new IntFileIterator(b);//copy of iterator b before next() function
		//if hash next()
		while (a.hasNext() && b.hasNext()) {
			//check the next() value of a and b
			int s = a.next();
			int t = b.next();
			//if s doesn't equal t
			if (s != t) {
				//we go on check the next value of a anf b,
				IntFileIterator aaa = new IntFileIterator(a);
				IntFileIterator bbb = new IntFileIterator(b);
				//and we increse the distance,
				distance++;
				//if the distance large than 1 ,return false;
				if (distance > 1) {
					return false;
				}
				//if the distance smaller than 1,
				//we just check aa and b, a and bb, aaa and bbb,
				return check(aa, b, distance) || check(a, bb, distance) || check(aaa, bbb, distance);
			} else {
				return check(a, b, distance);
			}
		}
		if (distance == 1) {
			return !a.hasNext() && !b.hasNext();
		} else { //distance == 0)
			//if distance == 0,we need to check the a or b hasNext or not
			IntFileIterator k = a.hasNext() ? a : b;
			int count = 0;
			while (k.hasNext()) {
				k.next();
				count++;
			}
			//if hasNext() and more than 1, which the distance between a and b are large than 1, so return false
			return k <= 1;
		}
	}
}