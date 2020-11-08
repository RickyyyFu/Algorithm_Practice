package Amazon;

import java.util.*;

/**
 * 
 * @author Ricky
 *	TreeMap	- record the number of stars met before when there is "|"   ->   presum
 *	O(S + N*log(S))
 *	O(S)
 */

public class ItemsInContainers {
	 public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
		 List<Integer> res = new ArrayList<>();
		 TreeMap<Integer, Integer> treemap = new TreeMap<>();
		 
		 int count = 0;
		 for(int i = 0; i < s.length(); i++) {
			 if(s.charAt(i) == '|') treemap.put(i, count);
			 else count++;
		 }
		 
		 for(int i = 0; i < startIndices.size(); i++) {
			 Integer start = treemap.ceilingKey(startIndices.get(i)-1);
			 Integer end = treemap.floorKey(endIndices.get(i)-1);
			 if(start == null || end == null || start >= end) res.add(0);
			 else res.add(treemap.get(end)-treemap.get(start));
		 }
		 
		 return res;
	}
	 
	public static void main(String[] args) {
		String s1 = "|**|*|*";
		List<Integer> si1 = new ArrayList<>();
		si1.add(1);	si1.add(1);
		List<Integer> ei1 = new ArrayList<>();
		ei1.add(5);	ei1.add(6);
		System.out.println(numberOfItems(s1, si1, ei1));
		
		String s2 = "*|*|";
		List<Integer> si2 = new ArrayList<>();
		si2.add(1);
		List<Integer> ei2 = new ArrayList<>();
		ei2.add(3);
		System.out.println(numberOfItems(s2, si2, ei2));
		
		String s3 = "*|*|*|";
		List<Integer> si3 = new ArrayList<>();
		si3.add(1);
		List<Integer> ei3 = new ArrayList<>();
		ei3.add(6);
		System.out.println(numberOfItems(s3, si3, ei3));
	}
}
