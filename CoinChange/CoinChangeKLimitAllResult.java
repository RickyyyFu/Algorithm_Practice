package CoinChange;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeKLimitAllResult {
	public static List<List<Integer>> changeK_print(int[] coins, int amount, int k) {
		List<List<Integer>> res = new ArrayList<>();
//		for(int i = 0; i < coins.length; i++) {
//			dfs(res, new ArrayList<Integer>(), coins, amount, 0, i);
//		}
		dfs(res, new ArrayList<Integer>(), coins, amount, k, 0, 0);
		return res;
	}
		
	public static void dfs(List<List<Integer>> res, List<Integer> list, int[] coins, int amount, int k, int cur, int start) {
		if(cur == amount && k == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		if(cur > amount) return;
		if(k == 0) return;
		
		for(int i = start; i < coins.length; i++) {
			list.add(coins[i]);
			dfs(res, list, coins, amount, k-1, cur+coins[i], i);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] c = {8,1,3,4,6,5,7,2};
		int amount = 8;
		int k = 4;
		System.out.println(changeK_print(c, amount, k));
	}
}
