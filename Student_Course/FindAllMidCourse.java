package Student_Course;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllMidCourse {
	static List<List<String>> paths = new ArrayList<>();
	public static Set<String> findAllMidCourse(String[][] pairs){
		Map<String, Integer> indegree = new HashMap<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String[] pair : pairs) {
			if(!indegree.containsKey(pair[0])) indegree.put(pair[0], 0);
			indegree.put(pair[1], indegree.getOrDefault(pair[1], 0)+1);
			
			if(!map.containsKey(pair[0])) map.put(pair[0], new ArrayList<>());
			map.get(pair[0]).add(pair[1]);
		}
		
		for(String course : indegree.keySet()) {
			if(indegree.get(course) == 0) dfs(new ArrayList<>(), map, course);
		}
		System.out.println(paths);
		
		Set<String> res = new HashSet<>();
		for(List<String> path : paths) {
			int n = path.size();
			if(n % 2 == 0) res.add(path.get(n/2 - 1));
			else res.add(path.get(n/2));
		}
		return res;
	}
	
	public static void dfs(ArrayList<String> path, Map<String, List<String>> map, String course) {
		path.add(course);
		
		if(!map.containsKey(course)) {
			paths.add(new ArrayList<>(path));
			return;
		}
		
		for(String next : map.get(course)) {
			dfs(path, map, next);
			path.remove(path.size()-1);
		}
	}
	
	public static void main(String[] args) {
		String[][] pairs = {
				{"Logic", "COBOL"},
				{"Data Structures", "Algorithms"},
				{"Creative Writing", "Data Structures"},
				{"Algorithms", "COBOL"},
				{"Intro to Computer Science", "Data Structures"},
				{"Logic", "Compilers"},
				{"Data Structures", "Logic"},
				{"Creative Writing", "System Administration"},
				{"Databases", "System Administration"},
				{"Creative Writing", "Databases"},
				{"Intro to Computer Science", "Graphics"}
		};
		
		System.out.println(findAllMidCourse(pairs));
	}
}
