/**
 * pick or not
 * O(2^n)
 */

package BuildTheSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildTheSubSeq_pickOrNot {
	public static List<String> buildSequences(String string){
		Set<String> set = new HashSet<>();
		recursion(set, "", string);
		return new ArrayList<String>(set);
	}
	
	public static void recursion(Set<String> set, String cur, String string) {
		if(string.length() == 0) {
			if(cur.length() > 0) set.add(cur);
			return;
		}
		
		recursion(set, cur, string.substring(1)); // not pick s.charAt(0)
		recursion(set, cur+string.charAt(0), string.substring(1)); // pick s.charAt(0)
	}
	
	public static void main(String[] args) {
		System.out.println("pick or not");
		System.out.println(buildSequences("abc"));
		System.out.println(buildSequences("aaa"));
	}
}	

