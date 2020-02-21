package Golden;

import java.util.HashMap;
import java.util.HashSet;

public class UnionFind {
	int uf[];
	int uf_size[];
	public UnionFind(int size){
		uf = new int[size];
		uf_size = new int[size];
		
		for(int i = 0 ; i < uf.length; i++){
			uf[i] = i ;
			uf_size[i] = 1;
		}
	}
	
	public void union(int i , int j){
		if(i < 0 || i >= uf.length || j <0 || j >= uf.length){return;}
		
		int root_i = findRoot(i);
		int root_j = findRoot(j);
		
		if(uf_size[root_i] > uf_size[root_j]){
			uf[root_j] = root_i;
			uf_size[root_i] += uf_size[root_j]; 
		}else{
			uf[root_i] = root_j;
			uf_size[root_j] += uf_size[root_i];
		}
	}
	
	private int findRoot(int index){
		while(index != uf[index]){
			uf[index] = uf[uf[index]];
			index = uf[index];
		}
		return index;
	}
	
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		uf.printUF();
		
		uf.union(0, 1);
		uf.union(2, 7);
		uf.union(1, 7);
		uf.printUF();
		
		uf.union(3, 6);
		uf.union(4, 5);
		uf.union(4, 9);
		
		uf.printUF();
		
		uf.union(0, 9);
		uf.printUF();
		
		uf.union(6, 8);
		uf.union(6, 0);
		uf.printUF();
	}
	
	private void printUF(){
		HashMap <Integer, HashSet<Integer>> print = new HashMap<>();
		for(int i = 0; i < uf.length; i++){
			int setRoot = findRoot(i);
			if(!print.containsKey(setRoot)){
				print.put(setRoot,new HashSet<>());
			}
			print.get(setRoot).add(i);
		}
		
		System.out.println(print);
		
		for(int i = 0 ; i < uf_size.length; i++){
			if(uf[i] == i){
				System.out.println("Size of " + i + " => " + uf_size[i]);
			}
		}
	}
}
