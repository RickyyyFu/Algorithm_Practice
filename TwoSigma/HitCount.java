package TwoSigma;

import java.util.*;

/**
 * 1. ����: [1,2,3,3,1,2], count: 3, ���: [3,4,4,3,-1,-1]
	������ʾ����: ��ÿ��index����, ���subarray�ĳ��ȡ���subarray��distinct��element���� = count, �����������Ϊ-1.��
	
	
	fu1: ������array, �ܷ�ָ������sum��ͬ��subarray
	fu2: ����array, �ܷ�ָ������sum��ͬ��subarray
	fu3: ����array, �ܷ�ָ������sum��ͬ��subarray	LC 1013
	fu4: ������array, �ܷ�ָ������sum��ͬ��sub sequence  LC 416
	
	698
	partition problem
 *
 */

public class HitCount {
	// brute force  O(n^2)
	// better?
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
	
	// two pointer
	public static int[] hitCounter1(int[] arr, int count) {
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : arr) map.put(n, 0);
		
		int distinct = 0;
		int left = arr.length-1, right = arr.length-1;
		while(left >= 0) {
			map.put(arr[left], map.get(arr[left])+1);
			if(map.get(arr[left]) == 1) distinct++;
			
			// move right pointer to reduce distinct
			if(distinct > count) {
				while(left < right && distinct > count) {
					map.put(arr[right], map.get(arr[right])-1);
					if(map.get(arr[right]) == 0) distinct--;
					right--;
				}
			}
			
			// move right pointer to get minimum length
			if(distinct == count) {
				while(left < right && map.get(arr[right]) > 1) {
					map.put(arr[right], map.get(arr[right])-1);
					right--;
				}
				// get res
				res[left] = right-left+1;
			}
			// move left
			left--;
		}
		for(int n : res) System.out.print(n + " ");
		System.out.println();
		return res;
	}
	
	public static void main(String[] args) {
		int[] a1 = {1,2,3,3,1,2};
		System.out.println(hitCounter(a1, 3));
		hitCounter1(a1, 3);
		
		int[] a2 = {1,2,3,3,1,2};
		System.out.println(hitCounter(a2, 1));
		hitCounter1(a2, 1);
		
		int[] a3 = {1,2,3,3,1,2};
		System.out.println(hitCounter(a3, 7));
		hitCounter1(a3, 7);
		
		int[] a4 = {1,1,1,1,1,2};
		System.out.println(hitCounter(a4, 2));
		hitCounter1(a4, 2);
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
//				map.put(preDistinct[i], new PriorityQueue<>()); // ��̣� ����
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
	
	
}
