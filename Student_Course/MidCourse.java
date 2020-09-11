// Topological sort - similar to Course 2 (LC 210)
// bfs

package Student_Course;

import java.util.*;

public class MidCourse {
	public static String getMidCourse(String[][] pairs) {
		Map<String, Integer> indegree = new HashMap<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String[] pair : pairs) {
			if(!indegree.containsKey(pair[0])) indegree.put(pair[0], 0);
			indegree.put(pair[1], indegree.getOrDefault(pair[1], 0)+1);
			
			if(!map.containsKey(pair[0])) map.put(pair[0], new ArrayList<>());
			map.get(pair[0]).add(pair[1]);
		}
		
		List<String> res = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		for(String course : indegree.keySet()) {
			if(indegree.get(course) == 0) queue.offer(course);
		}
		
		while(!queue.isEmpty()) {
			String course = queue.poll();
			res.add(course);
			
			if(map.containsKey(course)) {
				for(String next : map.get(course)) {
					indegree.put(next, indegree.get(next)-1);
					if(indegree.get(next) == 0) queue.offer(next);
				}
			}
		}
		
		int n = res.size();
		if(n % 2 == 0) return res.get(n/2 - 1);
		else return res.get(n/2);
	}
	
	public static void main(String[] args) {
		String[][] pairs1 = {
				{"Data Structures", "Algorithms"},
				{"Algorithms", "Foundations of Computer Science"},
				{"Foundations of Computer Science", "Logic"}
		};
		System.out.println(getMidCourse(pairs1));
		
		String[][] pairs2 = {
				{"Data Structures", "Foundations of Computer Science"},
				{"Foundations of Computer Science", "Logic"}
		};
		System.out.println(getMidCourse(pairs2));
		
		String[][] pairs3 = {
				{"Intro to Computer Science", "Graphics"}
		};
		System.out.println(getMidCourse(pairs3));
	}
}
