package Subsets;

import java.util.*;

public class Subsets {
	public static List<String> subsets(String[] strings){
		Set<String> res = new HashSet<>();
		backtracking(res, new StringBuilder(), strings, 0);
		return new ArrayList<String>(res);
	}
	
	public static void backtracking(Set<String> res, StringBuilder sb, String[] strings, int idx) {
		if(sb.length() != 0) res.add(sb.toString());
		
		for(int i = idx; i < strings.length; i++) {
			sb.append(strings[i]);
			backtracking(res, sb, strings, i+1);
			sb.deleteCharAt(sb.length()-1);
		}	
	}
	
	public static void main(String[] args) {
		String[] s1 = {"a","b","c"};
		System.out.println(subsets(s1));
		
		String[] s2 = {"a","a","b","c"};
		System.out.println(subsets(s2));
		
		String[] s3 = {"a","a","b"};
		System.out.println(subsets(s3));
	}
}
