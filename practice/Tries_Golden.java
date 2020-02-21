package Golden;

import java.util.HashMap;

public class Tries_Golden{

	private TrieNode rootNode;
	
	private void insertWord(String s){
		insertWord(rootNode, s, 0);
	}
	
	
	private void insertWord(TrieNode root, String s, int index){
		if(rootNode == null){
			rootNode = new TrieNode();
			root = rootNode;
		}
		if(index == s.length()){
			root.isEnd = true;
			return;
		}
		
		Character c = s.charAt(index);
		
		if(root.children.containsKey(c) == false){
			root.children.put(c,new TrieNode());
		}
		
		TrieNode n = root.children.get(c);
		insertWord(n,s,index+1);
	}

	public void printWords(TrieNode root, String prefix){
		if(root.isEnd){
			System.out.println(prefix);
		}
		
		if(root.children.size() == 0){
			return;
		}
		
		for(Character c : root.children.keySet()){
			TrieNode n = root.children.get(c);
			printWords(n,prefix + c);
		}
	}
	
	public void deleteWord(String s){
		delete(rootNode, s , 0);
	}
	
	private boolean delete(TrieNode root,String s, int index){
		if(index == s.length()){
			root.isEnd = false;			
			return root.children.size() == 0 ? true : false;
		}
		
		Character c = s.charAt(index);
		TrieNode n = root.children.get(c);
		if(n == null){
			return false;
		}
		
		boolean canDelete = delete(n, s, index+1);
		if(canDelete){
			root.children.remove(c);
		}
		
		return root.children.size() == 0 && root.isEnd == false ? true : false;
	}

	public static class TrieNode{
		HashMap <Character, TrieNode> children;
		boolean isEnd;
		
		public TrieNode(){
			children = new HashMap<Character, TrieNode>();
			isEnd = false;
		}
	}
	
	public static void main(String[] args) {
		Tries_Golden trie = new Tries_Golden();
		trie.insertWord("abc");
		trie.insertWord("abcd");
		trie.insertWord("aba");
		trie.insertWord("boy");
		trie.insertWord("girl");
		
		//trie.printWords(trie.rootNode, "");
		
		trie.delete(trie.rootNode, "abc", 0);
		trie.delete(trie.rootNode, "abcd", 0);
		trie.delete(trie.rootNode, "aba", 0);
		trie.delete(trie.rootNode, "boy", 0);
		trie.delete(trie.rootNode, "girl", 0);
		
		trie.printWords(trie.rootNode, "");
		
	}
}
