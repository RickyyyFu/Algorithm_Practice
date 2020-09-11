package CommonAncestor;

import java.util.*;

public class FindZeroOneAncestor {
	public static List<List<Integer>> findOor1(int[][] pairs){
		Map<Integer, Integer> map = new HashMap<>();
		for(int[] pair : pairs) {
			map.put(pair[0], map.getOrDefault(pair[0], 0));
			map.put(pair[1], map.getOrDefault(pair[1], 0) + 1);
		}
		
		List<Integer> zero = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		for(int point : map.keySet()) {
			if(map.get(point) == 0) zero.add(point);
			if(map.get(point) == 1) one.add(point);
		}
		res.add(zero);
		res.add(one);
		
		return res;
	}
	
	public static void main(String[] args) {
		int[][] pairs = {
				{1, 3}, {2, 3}, {3, 6}, {5, 6},
                {5, 7}, {4, 5}, {4, 8}, {8, 10} 
		};
		System.out.println(findOor1(pairs));
	}
}
