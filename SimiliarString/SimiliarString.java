package SimiliarString;

import java.util.*;

public class SimiliarString {
	public static List<String> excludeSimilarString(String[] words){
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>();
		
		for(String word : words) {
			String encode = encode(word);
			if(!set.contains(encode)) {
				set.add(encode);
				res.add(word);
			}
		}
		
		return res;
	}
	
	public static String encode(String s) {
		char[] chs = s.toCharArray();
		Arrays.sort(chs);
		return new String(chs);
	}
	
	public static void main(String[] args) {
		String[] words = {"abca", "aabc","abac","aaaabc", "app", "pap"};
		System.out.println(excludeSimilarString(words));
	}
}
