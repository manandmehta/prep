package Golden;
import java.util.*;

public class Tree {
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){ this.val = val; }
		public String toString(){
			return String.valueOf(this.val);
		}
	}
	
	private void dfs(TreeNode node){
		if(node == null){return;}
		System.out.println("Visiting :" + node.val);
		dfs(node.left);
		dfs(node.right);
	}
	
	private void bfs(TreeNode root){
		if(root == null){return; }
		Queue <TreeNode> bfsQ = new LinkedList<>();
		bfsQ.offer(root);
		while(!bfsQ.isEmpty()){
			TreeNode n = bfsQ.remove();
			System.out.println("Visiting :" + n.val);
			if(n.left != null){bfsQ.add(n.left);}
			if(n.right != null){bfsQ.add(n.right);}
		}
	}
	
	private void bfsLevel(TreeNode root){
		if(root == null){return ;}
		Queue <TreeNode> p_q = new LinkedList<>();
		p_q.offer(root);
		while(!p_q.isEmpty()){
			System.out.println(p_q);
			Queue<TreeNode> c_q = new LinkedList<>();
			while(!p_q.isEmpty()){
				TreeNode parent = p_q.remove();
				if(parent.left != null){c_q.offer(parent.left);}
				if(parent.right != null){c_q.offer(parent.right);}
			}
			p_q = c_q;
		}
	}
	
	public static void main(String[] args) {
		Tree t = new Tree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(8);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		
		//t.dfs(root);
		//t.bfs(root);
		t.bfsLevel(root);
	}
}
