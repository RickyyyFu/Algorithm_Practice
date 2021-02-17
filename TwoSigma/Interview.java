package TwoSigma;

import java.util.*;

public class Interview {
	public static int maximumInvites(int networkNodes, List<Integer> networkFrom, List<Integer> networkTo) {
        if(networkNodes == 1) return 1;
        
        // key: one person  value: list of his friends
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < networkFrom.size(); i++){
            int from = networkFrom.get(i);
            int to = networkTo.get(i);
            if(!graph.containsKey(from)) graph.put(from, new ArrayList<>());
            if(!graph.containsKey(to)) graph.put(to, new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        System.out.println(graph);
        
        // queue: store the node we should invite
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        // find endpoints
        for(int node : graph.keySet()){
            if(graph.get(node).size() == 1) {
                queue.offer(node);
                visited.add(node);
            }
        }
        
        int maxInvite = 0;
        while(!queue.isEmpty()){
            int size = queue.size(); // avoid calculate one node duplicatelly
            maxInvite += size;
            for(int k = 0; k < size; k++){
                int node = queue.poll();
                System.out.println(node);
                List<Integer> friends = graph.get(node);
                for(int n : friends) visited.add(n);
            }
            for(int node : graph.keySet()){
                if(!visited.contains(node)){
                    int count = 0;
                    for(int friend : graph.get(node)){
                        if(!visited.contains(friend)) count++;
                    }
                    // it is new endpoint
                    if(count == 1 || count == 0) {
                        queue.offer(node);
                        visited.add(node);
                        for(int friend : graph.get(node)) visited.add(friend);
                    }
                }
            }
        }
        return maxInvite;
    }
	
	 public static List<String> schedule(Map<String, Integer> codebases, Map<String, Set<String>> deps) {
	        if(codebases.size() == 0) return new ArrayList<>();
	        
	        Map<String, Integer> task_indegree = new HashMap<>();
	        for(String task : codebases.keySet()){
	            if(!deps.containsKey(task)) task_indegree.put(task, 0);
	            else task_indegree.put(task, deps.get(task).size());
	        }
	       
	        Map<String, Integer> task_remainingtime = new HashMap<>();
	        for(String t : codebases.keySet()){
	            task_remainingtime.put(t, codebases.get(t));
	        }
	        
	        Map<String, List<String>> task_next = new HashMap<>();
	        for(String task : codebases.keySet()){
	            if(!task_next.containsKey(task)) task_next.put(task, new ArrayList<>());
	        }
	        for(String to : deps.keySet()){
	            for(String from : deps.get(to)){
	                if(!task_next.containsKey(from)) task_next.put(from, new ArrayList<>());
	                task_next.get(from).add(to);
	            }
	        }
	        
	        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (task_remainingtime.get(a) - task_remainingtime.get(b)));
	        for(String task : codebases.keySet()){
	            if(task_indegree.get(task) == 0) pq.offer(task);
	        }
	        
	        
	        List<String> res = new ArrayList<>();
	        int T = 0;
	        while(!pq.isEmpty()){
	            String t = pq.peek();
	            int min_time = task_remainingtime.get(t);
	            
	            List<String> list = new ArrayList<>(pq);
	            StringBuilder sb = new StringBuilder();
	            sb.append(min_time).append(",");
	            for(String task : list) sb.append(task).append(",");
	            //sb.substring(0, sb.length()-1); // remove last ","
	            res.add(sb.toString().substring(0, sb.length()-1));
	            //System.out.println(sb.toString());
	            
	            for(String task : list){
	                int remaining_time = task_remainingtime.get(task) - min_time;
	                if(remaining_time == 0){
	                    pq.remove(task);
	                    // update indegree
	                    for(String next : task_next.get(task)){
	                        task_indegree.put(next, task_indegree.get(next)-1);
	                        if(task_indegree.get(next) == 0) pq.offer(next);
	                    }
	                }
	                else{
	                    task_remainingtime.put(task, remaining_time);
	                }
	            }
	            
	        }
	        
	        return res;
	    }
	
	
}
