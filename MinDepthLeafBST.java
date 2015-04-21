public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int minDepth = 1;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int curNum = 1;
		int nextNum = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			curNum--;

			if (cur.left == null && cur.right == null) {
				return minDepth;
			} 
			//返回结点的话可以
			// if (cur.left == null && cur.right == null) {
			// 		return cur;
			// }
			if (cur.left != null) {
				queue.offer(cur.left);
				nextNum++;
			} 
			if (cur.right != null) {
				queue.offer(cur.right);
				nextNum++;
			}

			if (curNum == 0) {
				curNum = nextNum;
				nextNum = 0;
				minDepth++;
			}
		}
		return minDepth;

	}
}