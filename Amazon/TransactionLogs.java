package Amazon;

import java.util.*;
/**
 * 
 * @author Ricky
 *	O(N)
 *	O(N)
 */
public class TransactionLogs {
	public static List<String> getFraudIds(String[] input, int threshold) {
		List<String> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for(String s : input) {
			String[] info = s.split("\s+");
			String user1 = info[0];
			String user2 = info[1];
			map.put(user1, map.getOrDefault(user1, 0)+1);
			if(!user1.equals(user2)) map.put(user2, map.getOrDefault(user2, 0)+1);
		}
		
		for(String id : map.keySet()) {
			if(map.get(id) >= threshold) res.add(id);
		}
		Collections.sort(res);
		
		return res;
	}
	
	public static void main(String[] args) {
		String[] input = new String[] { "345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77",
				"345366 38239 23", "029323 345366 13", "38239 38239 23" };
		System.out.println(getFraudIds(input, 3));
	}
}
