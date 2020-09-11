package WrapLine;

import java.util.*;

public class WrapLine {
	public static List<String> wrapLine(String[] words, int maxLength){
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		
		while(idx < words.length) {
			if(sb.length() == 0) sb.append(words[idx++]);
			else if(sb.length() + 1 + words[idx].length() <= maxLength) {
				sb.append("-");
				sb.append(words[idx++]);
			}
			else{
				res.add(sb.toString());
				sb.setLength(0);
			}
		}
		
		if(sb.length() != 0) res.add(sb.toString());
		return res;
	}
	
	public static void main(String[] args) {
		String[] words = {"1p3acres", "is", "a", "good", "place", "to", "communicate"};
		System.out.println(wrapLine(words, 12));
	}
}
