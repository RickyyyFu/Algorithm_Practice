package LongestSubarrayWithLimitedElement;

import java.util.HashSet;
import java.util.Set;

public class CheckIfLongest {
	public static boolean check(int[] a, int[] b, int[] c) {
		Set<Integer> set = new HashSet<>();
		for(int i : c) set.add(i);
		
		for(int i : b) 
			if(!set.contains(i)) return false;
		
		if(!isSubArray(a, b)) return false;
		
		int maxLength = 0;
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			if(set.contains(a[i])) {
				count++;
			}
			else {
				maxLength = Math.max(maxLength, count);
				count = 0;
			}
		}
		return b.length == maxLength;
	}
	 
	public static boolean isSubArray(int A[], int B[]) { 
		// Two pointers to traverse the arrays 
		int i = 0, j = 0; 

		// Traverse both arrays simultaneously 
		while (i < A.length && j < B.length) { 
			// If element matches increment both pointers 
			if (A[i] == B[j]) { 
				i++; 
				j++; 

				// If array B is completely traversed 
				if (j == B.length) return true; 
			} 
			// If not, increment i and reset j 
			else{ 
				i = i - j + 1; 
				j = 0; 
			} 
		} 
		return false; 
	} 
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = {2,3,4};
		int[] c = {1,2,3,4,5,6};
		System.out.println(check(a,b,c));
		
		int[] a1 = {1,2,3,4,5};
		int[] b1 = {2,3,4};
		int[] c1 = {2,3,4,6};
		System.out.println(check(a1,b1,c1));
		
		
	}
}
