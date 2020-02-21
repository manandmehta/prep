package Golden;

public class BST {
	public TreeNode addNode(TreeNode node, int val){
		if(node == null){ return new TreeNode(val);}
		
		if(val < node.val){
			node.left = addNode(node.left, val);
			node.size++;
		}else{
			node.right = addNode(node.right, val);
		}
		return node;
	}
	
	private int findRankFromVal(TreeNode node, int val, int runningRank){
		if(node == null){return -1;}
		
		if(node.val == val){
			return runningRank + node.size; 
		}
		
		if(val < node.val){
			return findRankFromVal(node.left, val, runningRank);
		}else{
			return findRankFromVal(node.right, val, runningRank + node.size + 1);
		}
	}
	
	private int findValFromRank(TreeNode node, int rank, int runningRank){
		if(node == null){return -1;}
		
		if(rank == runningRank + node.size){
			return node.val;
		}
		
		if(rank > runningRank + node.size){
			return findValFromRank(node.right, rank, runningRank + node.size + 1);
		}else{
			return findValFromRank(node.left, rank, runningRank);
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		TreeNode root = null;
		int a[] = new int[]{50,30,70,20,40,60,90,10,25,55,65,5,27};
		for(int n : a){
			root = bst.addNode(root, n);
		}
		
		for(int i = 0; i <= a.length ; i++){
			System.out.println("Value at Rank [" + i + "] is => " + bst.findValFromRank(root, i, 0) );
		}
		//bst.inorder(root, root);
		//bst.preorder(root);
		//bst.postorder(root);
	}
	
	private void inorder(TreeNode n, TreeNode root){
		if(n == null){return;}
		inorder(n.left, root);
		System.out.println(" Rank of " + n.val + " => " + findRankFromVal(root, n.val, 0));
		inorder(n.right, root);
	}
	
	private void preorder(TreeNode n){
		if(n == null){return;}
		System.out.print(" " + n.val);
		preorder(n.left);
		preorder(n.right);
	}
	
	private void postorder(TreeNode n){
		if(n == null){return;}
		postorder(n.left);
		postorder(n.right);
		System.out.print(" " + n.val);
	}

	private static class TreeNode{
		int size = 0, val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			size = 0;
			this.val = val;
		}
	}
}
