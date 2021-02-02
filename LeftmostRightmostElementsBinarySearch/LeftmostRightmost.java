package LeftmostRightmostElementsBinarySearch;

public class LeftmostRightmost {
	public static int leftmost(int[] A, int target) {
		int left = 0, right = A.length-1;
		int res = -1;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(A[mid] == target) {
				res = mid;
				right = mid - 1;
			}
			else if(A[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return res;
	}
	
	public static int rightmost(int[] A, int target) {
		int left = 0, right = A.length-1;
		int res = -1;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(A[mid] == target) {
				res = mid;
				left = mid + 1;
			}
			else if(A[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int A[] = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
		int target = 5;
		System.out.println(target + ": leftmost " + leftmost(A, target) + ", rightmost " + rightmost(A, target));
		
		int t = 0;
		System.out.println(t + ": leftmost " + leftmost(A, t) + ", rightmost " + rightmost(A, t));
	}
}
