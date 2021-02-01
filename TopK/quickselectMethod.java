package TopK;

import java.util.*;

public class quickselectMethod {
	static int[] A;
	public static int[] topKSmall(int[] arr, int K) {
		A = arr;
		int n = A.length;
		quickselect(0, n-1, K);
		return Arrays.copyOfRange(A, 0, K);
	}
	
	public static void quickselect(int left, int right, int target) {
		if(left == right) return;
		
		Random random = new Random();
		int pivot_idx = left + random.nextInt(right-left);
		pivot_idx = partition(left, right, pivot_idx);
		
		if(target == pivot_idx) return;
		else if(target < pivot_idx) quickselect(left, pivot_idx-1, target);
		else if(target > pivot_idx) quickselect(pivot_idx+1, right, target);
	}
	
	public static int partition(int left, int right, int pivot_idx) {
		int pivot = A[pivot_idx];
		
		swap(pivot_idx, right);
		int cur = left;
		for(int i = left; i <= right; i++) {
			if(A[i] < pivot) {
				swap(cur, i);
				cur++;
			}
		}
		swap(cur, right);
		return cur;
	}
	
	public static void swap(int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	
	public static void main(String[] args) {
		int[] A = {2,2,1,4,5,7};
		int k = 1;
		int[] res = topKSmall(A, k);
		for(int n : res) {
			System.out.print(n + " ");
		}
	}
}
