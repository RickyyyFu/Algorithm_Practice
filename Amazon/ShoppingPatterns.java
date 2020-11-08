package Amazon;

import java.util.*;

/**
 * 
 * 	@author Ricky
 *	
 */
public class ShoppingPatterns {
	public static int getMinScore(int productNodes, List<Integer> productsFrom, List<Integer> productsTo) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for(int i = 0; i < productsFrom.size(); i++) {
			int from = productsFrom.get(i);
			int to = productsTo.get(i);
			if(!graph.containsKey(from)) graph.put(from, new HashSet<>());
			if(!graph.containsKey(to)) graph.put(to, new HashSet<>());
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		int res = Integer.MAX_VALUE;
		for(int i : graph.keySet()) {
			for(int j : graph.get(i)) {
				for(int k : graph.get(j)) {
					if(graph.get(i).contains(k)) res= Math.min(res, graph.get(i).size()+graph.get(j).size()+graph.get(k).size()-6);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Integer l1[] = new Integer[] {1,2,2,3,4,5};
		List<Integer> a1 = Arrays.asList(l1);
		Integer l2[] = new Integer[] {2,4,5,5,5,6};
		List<Integer> a2 = Arrays.asList(l2);
		System.out.println(getMinScore(6,a1, a2));
		
		Integer l3[] = new Integer[] {1,1,2,2,3,4};
		List<Integer> a3 = Arrays.asList(l3);
		Integer l4[] = new Integer[] {2,3,3,4,4,5};
		List<Integer> a4 = Arrays.asList(l4);
		System.out.println(getMinScore(5,a3, a4));

	}
}
