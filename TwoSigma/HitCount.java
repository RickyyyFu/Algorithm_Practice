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
