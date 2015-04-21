/*
	The distance between two points in binary tree
*/

/*
	假设给定的节点为node1, node2，可以分为下面两种情况：
	1) node1是node2的祖先节点或孩子节点，可以理解为两个节点在一条线上。 
	   例如：Dist(2,4), Dist(6,1)
	2) node1 和 node2 没有直接或间接的父子关系。 
	   例如，Dist(4,3)， 他们需要一个共同的祖先节点1 连接起来。
*/

/*
	关于两个节点的最低公共祖先(LCA)问题，可以参考：寻找二叉树两个节点的最低公共祖先
	通过观察可以总结出下面的公式, lca是两个节点的最低公共祖先节点:
	Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
 	这个公式已经含盖了上面的两种情况。先找出lca，再求root节点到某个节点的距离就比较简单了。
*/

 /*
 	step1: find the lca
 	step2: caculate the level of node1 and node2
 	step3: use the formula : node1_level + node2_level - 2 * LCA_level
 */

public class TreeNodesDistance {
	public static int dstancenTreeNodes(TreeNode root, TreeNode node1, TreeNode node2) {
		TreeNode lca = lowestCommonAncester(root, node1, node2);
		int dis_lca = findLevel(root, lca);
		int dist1 = findLevel(root, node1);
		int dist2 = findLevel(root, node2);
		return dist1 + dist2 - 2 * dis_lca;
	}

	//we notice that the level of the root is 0
	//this method is used to find the node's level according with the root node
	public static int findLevel(TreeNode root, TreeNode node) {
		if (root == null) {
			return -1;
		}
		if (root.val == node.val) {
			return 0;
		}
		int level = findLevel(root.left, node);
		if (level == -1) {
			level = findLevel(root.right, node);
		}
		if (level != -1) {
			return level + 1;
		}
		return -1;
	}

	//find the lowestCommonAncester
	public static TreeNode lowestCommonAncester(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return root;
		}
		//if at least one matched, no need to continue
		//that is the LCA for this root
		if (root == A || root == B) {
			return root;
		}
		//recursive find the lowestCommonAncester in left tree, and right tree
		TreeNode leftCh = lowestCommonAncester(root.left, A, B);
		TreeNode rightCh = lowestCommonAncester(root.right, A, B);
		//if leftCh and rightCh are not null,which means they are in separate branch
		if (leftCh != null && rightCh != null) {
			return root; //
		}
		//either one node is on one branch,
		//or none was found in any of the branches
		return leftCh == null ? rightCh : leftCh;
	}
}
