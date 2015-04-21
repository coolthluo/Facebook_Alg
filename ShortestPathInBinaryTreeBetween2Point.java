/*
	Shortest path in a binary tree between two nodes
	http://www.cnblogs.com/EdwardLiu/p/4265448.html
*/
public class Solution {
	public static List<TreeNode> shortestPath(TreeNode root, TreeNode a, TreeNode b) {
		//create two path, to store the shortest path from a to lca,and b to lca
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();

		//find the LowestCommonAncestor
		TreeNode LCA = lowestCommonAncestor(root, a, b);

		//recursive find the left path
		helper(LCA.left, a, b, path1, new ArrayList<TreeNode>());
		//recursive find the right path.
		helper(LCA.right, a, b, path2, new ArrayList<TreeNode>());
		//since the path1's sequence from top to bottom. we need the reverse the pah
		Collections.reverse(path1);
		//reverse(path1) + LCA + path2 == Path
		path1.add(LCA);
		path1.addAll(new ArrayList<TreeNode>(path2));
		return path1;
	}

	public void helper(TreeNode root, TreeNode a, TreeNode b, ArrayList<TreeNode> outpath, 
		ArrayList<TreeNode> temp) {
		if (root == null) {
			return ;
		}
		temp.add(root);
		if (root == a || root == b) {
			outpath = new ArrayList<TreeNode>(temp);
			return;
		}
		helper(root.left, a, b, outpath, temp);
		helper(root.right, a, b, outpath, temp);
		temp.remove(tmep.size() - 1);
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null) {
			return null;
		}
		//if at least one matched, no need to continue
		//that is the LCA for this root
		if (root == a || root == b) {
			return root;
		}
		//recursive find the lowestCommonAncester in left tree, and right tree
		TreeNode left = lowestCommonAncestor(root.left, a, b);
		TreeNode right = lowestCommonAncestor(root.right, a, b);
		//if leftCh and rightCh are not null,which means they are in separate branch
		if (left != null && right != null) {
			return root;
		}
		//either one node is on one branch,
		//or none was found in any of the branches
		return left != null ? left : right;
	}
}