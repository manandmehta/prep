package Golden;
import java.util.*;

public class Graph {
	private Map<String, List<String>> adjc;
	private Deque <String> topostck; 
	
	public Graph(Map <String, List<String>> adjc){
		this.adjc = adjc;
		this.topostck = new LinkedList<>();
	}
	
	public void dfs(){
		Set<String> discovered = new HashSet<>(), processed = new HashSet<>();
		
		for(String s : adjc.keySet()){
			if(!processed.contains(s)){
				dfs(s, discovered, processed);
			}
		}
		
		System.out.println("~~~~ TOPO Stack ~~~~~");
		printTopologicalSort();
	}
	
	private void dfs(String n, Set<String> discovered, Set<String> processed){
		if(discovered.contains(n)){
			System.out.println("CYCLE DETECTED AT :>" + n);
			return;
		}
		discovered.add(n);
		System.out.println("Visiting : " + n);
		List <String> neighbor = adjc.get(n) == null ? new ArrayList<>() : adjc.get(n);
		for(String next : neighbor){
			if(!processed.contains(next)){
				dfs(next, discovered, processed);
			}
		}
		
		processed.add(n);
		discovered.remove(n);
		topostck.push(n);
	}
	
	public void bfs(){
		Set <String> visited = new HashSet<>();
		for(String node : adjc.keySet()){
			if(!visited.contains(node)){
				bfs(node, visited);
			}
		}
	}
	
	private void bfs(String node, Set <String> visited){
		Queue <String> q = new LinkedList<>();
		q.add(node);
		visited.add(node);
		
		while(!q.isEmpty()){
			String n = q.remove();
			System.out.println("Visiting > " + n);
			if(adjc.get(n) != null){
				for(String neighbor : adjc.get(n)){
					if(!visited.contains(neighbor)){
						q.add(neighbor);
						visited.add(neighbor);
					}
				}
			}
		}
	}
	
	private void printTopologicalSort(){
		while(!topostck.isEmpty()){
			System.out.println(" "+ topostck.pop());
		}
	}
	
	public static void main(String[] args) {
		Map <String, List<String>> adjc = new HashMap<>();
		adjc.put("a", new ArrayList<>());
		adjc.put("b", new ArrayList<>());
		adjc.put("c", new ArrayList<>());
		adjc.put("d", new ArrayList<>());
		adjc.put("e", new ArrayList<>());
		adjc.put("f", null);
		adjc.put("g", new ArrayList<>());
		adjc.put("h", null);
		adjc.put("i", null);
		
		adjc.get("a").add("b");
		adjc.get("a").add("c");
		adjc.get("b").add("e");
		adjc.get("c").add("b");
		adjc.get("c").add("d");
		adjc.get("c").add("g");
		adjc.get("c").add("g");
		adjc.get("d").add("f");
		adjc.get("e").add("h");
		adjc.get("g").add("f");
		adjc.get("g").add("a");
		
		Graph g = new Graph(adjc);
		g.bfs();
		g.dfs();
	}
}
