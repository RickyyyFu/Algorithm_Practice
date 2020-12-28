package TwoSum;

import java.util.*;

public class TwoSum_BackTracking {
	static List<Integer> res = new ArrayList<>();
	static int c = 0;
	public static List<Integer> sum_combine(int[] arr, int target){
		dfs(arr, new ArrayList<Integer>(), target, 0, 0);
		return res;
	}
	
	public static void dfs(int[] arr, List<Integer> list, int target, int sum, int idx) {
		System.out.println(c++);
		if(sum > target) return;
		if(sum == target) {
			res = new ArrayList<>(list);
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			list.add(i);
			dfs(arr, list, target, sum+arr[i], i+1);
			list.remove(list.size()-1);
			
			if(res.size() > 0) return; // stop dfs
		}
		
	}
	
	public static void main(String[] args) {
//		int[] a1 = {1,2,5,7,9};
//		System.out.println(sum_combine(a1, 10));
		
//		int[] a2 = {9,1,5,7,9};
//		System.out.println(sum_combine(a2, 10));
		
		int[] a3 = {9,1,5,7,9};
		System.out.println(sum_combine(a3, 1000));
	}
}
