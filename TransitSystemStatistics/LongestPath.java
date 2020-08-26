package TransitSystemStatistics;

import java.util.*;

public class LongestPath {
	static Map<String, Map<String, Integer>> graph = new HashMap<>();
	static List<String> path = new ArrayList<>();
	static int max = 0;
	public static String parseInput(String str) {
		String[] info = str.split(":");
		String c1 = info[0];
		String c2 = info[1];
		int distance = Integer.valueOf(info[2]);
		
		if(!graph.containsKey(c1)) graph.put(c1, new HashMap<>());
		if(!graph.containsKey(c2)) graph.put(c2, new HashMap<>());
		graph.get(c1).put(c2, distance);
		graph.get(c2).put(c1, distance);
		
		if(graph.keySet().size() < 3) {
			System.out.println("NONE");
			return "NONE";
		}
		
		for(String city : graph.keySet()) {
			dfs(new ArrayList<>(), new HashSet<>(), city, 0, 0);
		}
		
		Collections.sort(path);
		
		String res =  max + ":" +  path.get(0) + ":" + path.get(1) + ":" + path.get(2);
		System.out.println(res);
		return res;
	}
	
	public static void dfs(List<String> list, Set<String> visited, String cur, int dis, int step) {
		if(visited.contains(cur)) return;
		list.add(cur);
		visited.add(cur);
		
		if(step == 2) {
			if(dis > max) {
				path = new ArrayList<>(list);
				max = dis;
				return;
			}
		}
		
		for(String next : graph.get(cur).keySet()) {
			dfs(list, visited, next, dis+graph.get(cur).get(next), step+1);
		}
		visited.remove(cur);
		list.remove(list.size()-1);
	}
	
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			int N = Integer.valueOf(scanner.nextLine());
			for(int i = 0; i < N; i++) {
				String input = scanner.nextLine();
				parseInput(input);
			}
		}
	}
}
