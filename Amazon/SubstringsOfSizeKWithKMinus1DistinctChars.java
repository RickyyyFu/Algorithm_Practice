package Amazon;

import java.util.*;

/**
 * 
 * @author Ricky
 *	two pointer + sliding window + HashMap
 *	O((N-k)*k)
 *	O(N)
 *
 */

public class SubstringsOfSizeKWithKMinus1DistinctChars {
	public static List<String> findSubstrings(String str, int k) {
		Set<String> set = new HashSet<>();
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		char[] chs = str.toCharArray();
		int left = 0, right = 0;
		while(right < chs.length) {
			char c = chs[right];
			map.put(c, map.getOrDefault(c, 0)+1);
			sb.append(c);
			
			//System.out.println(left + " " + right);
			if(right-left+1 == k) {
				if(map.size() == k-1) set.add(sb.toString());
				
				map.put(chs[left], map.get(chs[left])-1);
				if(map.get(chs[left]) == 0) map.remove(chs[left]);
				sb.deleteCharAt(0);
				left++;
			}
			right++;
		}
		return new ArrayList<>(set);
	}
	
	public static void main(String[] args) {
		String word = "awagla";
		int k = 4;
		System.out.println(findSubstrings(word, k));
		
		String word1 = "democracy";
		int k1 = 5;
		System.out.println(findSubstrings(word1, k1));
		
		String word2 = "wawaglknagagwunagkwkwagl";
		int k2 = 4;
		System.out.println(findSubstrings(word2, k2));
	}
}
