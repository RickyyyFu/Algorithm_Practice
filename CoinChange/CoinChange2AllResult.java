/**
 * 	coin change 2 to print all combinations
 * 
 * 	DFS
 */

package CoinChange;

import java.util.*;

public class CoinChange2AllResult {
	public static List<List<Integer>> change2_print(int[] coins, int amount) {
		List<List<Integer>> res = new ArrayList<>();
//		for(int i = 0; i < coins.length; i++) {
//			dfs(res, new ArrayList<Integer>(), coins, amount, 0, i);
//		}
		dfs(res, new ArrayList<Integer>(), coins, amount, 0, 0);
		return res;
	}
		
	public static void dfs(List<List<Integer>> res, List<Integer> list, int[] coins, int amount, int cur, int start) {
		if(cur == amount) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		if(cur > amount) return;
		
		for(int i = start; i < coins.length; i++) {
			list.add(coins[i]);
			dfs(res, list, coins, amount, cur+coins[i], i);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] c1 = {1,2,5}; 
		int a1 = 5;
		System.out.println(change2_print(c1, a1));
		
		int[] c2 = {2}; 
		int a2 = 3;
		System.out.println(change2_print(c2, a2));
		
		int[] c3 = {10}; 
		int a3 = 10;
		System.out.println(change2_print(c3, a3));
	}
}
