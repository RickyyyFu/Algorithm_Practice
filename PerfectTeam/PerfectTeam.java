package PerfectTeam;

import java.util.*;

public class PerfectTeam {
	public static int differentTeams(String skills) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('p', 0);
		map.put('c', 0);
		map.put('m', 0);
		map.put('b', 0);
		map.put('z', 0);
		
		char[] s = skills.toCharArray();
		for(char skill : s) map.put(skill, map.get(skill)+1);
		
		int min = Integer.MAX_VALUE;
		for(char skill : map.keySet()) {
			min = Math.min(min, map.get(skill));
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println(differentTeams("pcmbzpcmbz"));
		System.out.println(differentTeams("pcmbzpcmz"));
		System.out.println(differentTeams("pcmzpcmz"));
	}
}
