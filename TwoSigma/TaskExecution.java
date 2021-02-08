package TwoSigma;

import java.util.*;

public class TaskExecution {
	public static List<String> getSchedule(char[] name, int[] time, char[][] dependency){
		Map<Character, Integer> task_time = new HashMap<>();
		for(int i = 0; i < name.length; i++) {
			task_time.put(name[i], time[i]);
		}
		
		Map<Character, List<Character>> task_next = new HashMap<>();
		Map<Character, Integer> task_indegree = new HashMap<>();
		for(char t : name) {
			task_next.put(t, new ArrayList<>());
			task_indegree.put(t, 0);
		}
		
		for(char[] pair : dependency) {
			task_next.get(pair[0]).add(pair[1]);
			task_indegree.put(pair[1], task_indegree.get(pair[1])+1);
		}
		
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (task_time.get(a)-task_time.get(b)));
		for(char t : name) {
			if(task_indegree.get(t) == 0) {
				pq.offer(t);
			}
		}
		
		List<String> res = new ArrayList<>();
		int round = 0;
		while(!pq.isEmpty()) {
			round++;
			
			char t = pq.peek();
			int min_time = task_time.get(t);
			
			List<Character> list = new ArrayList<>(pq); // convert to list!!!
			StringBuilder sb = new StringBuilder();
			sb.append(round).append(" ");
			for(char task : list) sb.append(task).append(",");
			sb.setCharAt(sb.length()-1, ' ');
			sb.append(min_time);
			res.add(sb.toString());

			for(char task : list) { // use the converted list!!!
				int remaining_time = task_time.get(task) - min_time;
				if(remaining_time == 0) {
					pq.remove(task);
					for(char next : task_next.get(task)) {
						task_indegree.put(next, task_indegree.get(next)-1);
						if(task_indegree.get(next) == 0) pq.offer(next);
					}
				}
				else {
					task_time.put(task, remaining_time);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		char[] name = {'A', 'B', 'D', 'E'};
		int[] time = {2, 3, 3, 6};
		char[][] dependency = {{'B','D'}};
		System.out.println(getSchedule(name, time, dependency));
	}
}
