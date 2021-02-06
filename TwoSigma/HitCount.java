package TwoSigma;

import java.util.*;

/**
 * 1. 输入: [1,2,3,3,1,2], count: 3, 输出: [3,4,4,3,-1,-1]
	输出里表示的是: 从每个index出发, 最短subarray的长度。（subarray中distinct的element数量 = count, 如果不满足则为-1.）
	
	
	fu1: 正整数array, 能否分割成两个sum相同的subarray
	fu2: 整数array, 能否分割成两个sum相同的subarray
	fu3: 整数array, 能否分割成三个sum相同的subarray	LC 1013
	fu4: 正整数array, 能否分割成两个sum相同的sub sequence  LC 416
	
	698
	partition problem
 *
 */

// brute force  O(n^2)
// better?
public class HitCount {
	public static int[] hitCounter(int[] arr, int count) {
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);
		if(count > arr.length) return res;
		
		for(int i = 0; i < arr.length; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = i; j < arr.length; j++) {
				set.add(arr[j]);
				if(set.size() == count) {
					res[i] = j-i+1;
					break;
				}
			}
		}
		for(int n : res) System.out.print(n + " ");
		return res;		
	}
	
	
/**	
 *  wrong: because pre[i,j] != pre[j]-pre[i]
 *  Map<Integer, PriorityQueue>   <prefixSetofSize, PQ of Index(large->small)>
*/
//	public static int[] hitCounter(int[] arr, int count) {
//		int[] res = new int[arr.length];
//		Arrays.fill(res, -1);
//		if(count > arr.length) return res;
//		
//		Set<Integer> set = new HashSet<>();
//		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
//		
//		int[] preDistinct = new int[arr.length];
//		for(int i = 0; i < arr.length; i++) {
//			set.add(arr[i]);
//			preDistinct[i] = set.size();
//			
//			if(!map.containsKey(preDistinct[i])) {
//				map.put(preDistinct[i], new PriorityQueue<>()); // 最短， 升序
//			}
//			map.get(preDistinct[i]).add(i);
//		}
//		
//		for(int i = 0; i <= arr.length-count; i++) {
//			if(i == 0) {
//				if(map.containsKey(count)) res[i] = map.get(count).peek()+1;
//			}
//			else {
//				if(map.containsKey(preDistinct[i-1]+count)) res[i] = map.get(preDistinct[i-1]+count).peek();
//			}
//		}
//		
//		System.out.println(map);
//		for(int n : res) System.out.print(n + " ");
//		return res;
//	}
	
	public static void main(String[] args) {
		int[] a1 = {1,2,3,3,1,2};
		System.out.println(hitCounter(a1, 3));
		
		int[] a2 = {1,2,3,3,1,2};
		System.out.println(hitCounter(a2, 1));
		
		int[] a3 = {1,2,3,3,1,2};
		System.out.println(hitCounter(a3, 7));
		
		int[] a4 = {1,1,1,1,1,2};
		System.out.println(hitCounter(a4, 2));
	}
}
