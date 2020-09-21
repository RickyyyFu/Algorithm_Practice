package MinimumDiscreteKinds;

import java.util.*;

public class MapSortByValue {
	public static HashMap<Integer, Integer> sortByValues(Map<Integer, Integer> map){
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
				return (a.getValue()).compareTo(b.getValue());
			}
		});
		
		HashMap<Integer, Integer> sorted_map = new LinkedHashMap<>(); // LinkedHashMap
		for(Map.Entry<Integer, Integer> entry : list) sorted_map.put(entry.getKey(), entry.getValue());
		
		return sorted_map;
	}
	
	public static int deteleItems(int[] IDs, int limit) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int id : IDs) {
			map.put(id, map.getOrDefault(id, 0) + 1);
		}
		HashMap<Integer, Integer> sorted_map = sortByValues(map);
		
		for(int key : sorted_map.keySet()) {
			if(sorted_map.get(key) > limit) {
				sorted_map.put(key, sorted_map.get(key)-limit);
				break;
			}
			else {
				limit -= sorted_map.get(key);
				// sorted_map.remove(key);
				sorted_map.put(key, 0);
			}
		}
		
		int cnt = 0;
		for(int key : sorted_map.keySet()) {
			if(sorted_map.get(key) != 0) cnt++;
		}
		return cnt;
		
	}
	
	public static void main(String[] args) {
		int[] IDs = {1,2,2,1,1,3};
		System.out.println(deteleItems(IDs, 2));
		System.out.println(deteleItems(IDs, 3));
	}
}
