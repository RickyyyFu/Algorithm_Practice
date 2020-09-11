/**
 * We want to find employees who badged into our secured room unusually often. We have an unordered list of names and access times over a single day. 
   Access times are given as three or four-digit numbers using 24-hour time, such as "800" or "2250"
 * Write a function that finds anyone who badged into the room 3 or more times in a 1-hour period, 
   and returns each time that they badged in during that period. (If there are multiple 1-hour periods where this was true, just return the first one.
 */

package BadgeAccess;

import java.util.*;

public class MultipleAccess {
	public static Map<String, List<Integer>> multipleAccess(String[][] records){
		Map<String, List<Integer>> map = new HashMap<>();
		for(String[] record : records){
			String name = record[0];
			int time = Integer.valueOf(record[1]);
			if(!map.containsKey(name)) map.put(name, new ArrayList<>());
			map.get(name).add(time);
		}
		
		Map<String, List<Integer>> res = new HashMap<>();
		for(String name : map.keySet()) {
			List<Integer> timestamps = map.get(name);
			Collections.sort(timestamps);
			System.out.println(name +":" + timestamps);
			
			int i = 0;
			List<Integer> list = new ArrayList<>();
			for(int j = i; j < timestamps.size(); j++) {
				if(timeDiff(timestamps.get(i), timestamps.get(j)) < 60) {
					list.add(timestamps.get(j));
				}
				else {
					if(list.size() >= 3) {
						if(!res.containsKey(name)) res.put(name, list);
					}
					list = new ArrayList<>();
					i = j;
				}
			}
		} 
		return res;
	}
	
	public static int timeDiff(int s, int e) {
		int s_hour = s / 100;
		int e_hour = e / 100;
		int s_minute = s % 100;
		int e_minute = e % 100;
		return e_hour*60+e_minute - (s_hour*60+s_minute);
	}
	
	public static void main(String[] args) {
		String[][] records = {
				{"Paul", "1355"},
				{"Jennifer", "1910"},
				{"John", "830"},
				{"Paul", "1315"},
				{"John", "835"},
				{"Paul", "1405"},
				{"Paul", "1630"},
				{"John", "855"},
				{"John", "915"},
				{"John", "930"},
				{"Jennifer", "1335"},
				{"Jennifer", "730"},
				{"John", "1630"}
		};
		
		System.out.println(multipleAccess(records));
	}
}
