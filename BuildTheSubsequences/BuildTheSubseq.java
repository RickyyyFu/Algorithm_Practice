/**
 * backtracking
 */

package BuildTheSubsequences;

import java.util.*;

public class BuildTheSubseq {
	public static List<String> buildSequences(String string){
		Set<String> set = new HashSet<>();
		backtracking(set, "", string, 0);
		return new ArrayList<String>(set);
	}
	
	public static void backtracking(Set<String> set, String cur, String string, int start) {
		if(cur.length() > 0) set.add(cur);
		
		for(int i = start; i < string.length(); i++) {
			cur += string.charAt(i);
			backtracking(set, cur, string, i+1);
			cur = cur.substring(0, cur.length()-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("backtracking");
		System.out.println(buildSequences("abc"));
		System.out.println(buildSequences("aaa"));
	}
}
