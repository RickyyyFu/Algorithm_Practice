package revome_balloon;

import java.util.*;

public class Balloon_Map {
	public static int solution(String s) {
		int res = Integer.MAX_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		res = Math.min(res, map.getOrDefault('B', 0));
		res = Math.min(res, map.getOrDefault('A', 0));
		res = Math.min(res, map.getOrDefault('L', 0) / 2);
		res = Math.min(res, map.getOrDefault('O', 0) / 2);
		res = Math.min(res, map.getOrDefault('N', 0));
		
		return res;
	}
	
	public static void main(String[] args) {
		float start = System.currentTimeMillis();
	    int res1 = solution("BBAAOOONXXOLLLNL");
	    float end = System.currentTimeMillis();
	    System.out.println(res1);
	    System.out.println("Total the time taken process :" + (end - start) + " milisec.");
	}
}
