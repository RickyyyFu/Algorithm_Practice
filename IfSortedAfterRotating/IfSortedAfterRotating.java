package IfSortedAfterRotating;

public class IfSortedAfterRotating {
	public static boolean isPossible(int[] arr) {
		if(isSorted(arr, 0, arr.length-1)) return true;
		
		int idx = 0;
		while(arr[idx] == arr[arr.length-1]) idx++;
		if(isSorted(arr, idx, arr.length-1)) return true;
		
		// should descending
		if(arr[idx] < arr[arr.length-1]) {
			int break_idx = idx;
			while(break_idx < arr.length-1 && arr[break_idx] >= arr[break_idx+1]) break_idx++;
			
			for(int i = break_idx+1; i < arr.length-1; i++)
				// find ascending
				if(arr[i] < arr[i+1]) return false;
		}
		// should ascending
		else if(arr[idx] > arr[arr.length-1]) {
			int break_idx = idx;
			while(break_idx < arr.length-1 && arr[break_idx] <= arr[break_idx+1]) break_idx++;
			
			for(int i = break_idx+1; i < arr.length-1; i++)
				// find descending
				if(arr[i] > arr[i+1]) return false;
		}
		return true;
	}
	
	public static boolean isSorted(int[] arr, int start, int end) {
		int idx1 = 0, idx2 = 0;
		for(int i = start; i < end; i++) {
			if(arr[i] <= arr[i+1]) idx1++;
			if(arr[i] >= arr[i+1]) idx2++;
		}
		
		return idx1 == end-start || idx2 == end-start;
	}
	
	public static void main(String[] args) {
		int[] a1 = {1, 2, 3, 4}; // t
		int[] a2 = {1, 2, 3, 2}; // f
		int[] a3 = {4, 5, 6, 2, 3}; // t
		int[] a4 = {1, 2, 4, 3, 5}; // f
		int[] a5 = {5, 1, 2, 3}; // t
		int[] a6 = {5, 4, 3, 2}; // t
		int[] a7 = {6, 2, 5, 4}; // f
		int[] a8 = {5, 4, 7, 6}; // t
		int[] a9 = {1, 4, 3, 2}; // t
		int[] a10 = {2, 4, 3, 2}; // t
		int[] a11 = {2, 4, 5, 2}; // t
		int[] a12 = {2, 1, 5, 2}; // t
		int[] a13 = {2, 4, 5, 2, 1}; // f
		System.out.println(isPossible(a1));
		System.out.println(isPossible(a2));
		System.out.println(isPossible(a3));
		System.out.println(isPossible(a4));
		System.out.println(isPossible(a5));
		System.out.println(isPossible(a6));
		System.out.println(isPossible(a7));
		System.out.println(isPossible(a8));
		System.out.println(isPossible(a9));
		System.out.println(isPossible(a10));
		System.out.println(isPossible(a11));
		System.out.println(isPossible(a12));
		System.out.println(isPossible(a13));
	}
}
