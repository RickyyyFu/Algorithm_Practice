package EdgeToLinkedArray;

import java.util.*;

public class EdgeToLinkedArray {
	public static List<Integer> edgeToList(int[][] edges){
		Map<Integer, List<Integer>> edge = new HashMap<>();
		Set<Integer> once = new HashSet<>();
		for(int[] e : edges) {
			int pos1 = e[0];
			int pos2 = e[1];
			if(once.contains(pos1)) once.remove(pos1);
			else once.add(pos1);
			if(once.contains(pos2)) once.remove(pos2);
			else once.add(pos2);
			
			if(!edge.containsKey(pos1)) edge.put(pos1, new ArrayList<>());
			if(!edge.containsKey(pos2)) edge.put(pos2, new ArrayList<>());
			edge.get(pos1).add(pos2);
			edge.get(pos2).add(pos1);
		}
		
		List<Integer> res = new ArrayList<>();
		int[] endpoint = new int[2];
		int idx = 0;
		for(int pos : once) {
			endpoint[idx] = pos;
			idx++;
		}
		dfs(edge, endpoint[0], endpoint[1], res, new HashSet<>());
		
		return res;
	}
	
	public static void dfs(Map<Integer, List<Integer>> edge, int pos, int target, List<Integer> res, Set<Integer> visited) {
		if(pos == target) {
			res.add(pos);
			return;
		}
		
		res.add(pos);
		visited.add(pos);
		for(int next : edge.get(pos)) {
			if(!visited.contains(next)) dfs(edge, next, target, res, visited);
		}
	}
	
	public static void main(String[] args) {
		int[][] edges = {
				{3,5},{5,1},{1,2},{2,4}
		};
		System.out.println(edgeToList(edges));
	}
}
