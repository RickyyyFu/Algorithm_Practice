package minimum_sum_unique_array;

import java.util.*;

public class Min_sum_unique_array {
	public static int minSum(int[] array) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		
		for(int n : array) {
			while(set.contains(n)) {
				n++;
			}
			set.add(n);
			sum += n;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 1, 1};
		System.out.println(minSum(a));
		
		int[] b = {0, 0, 0, 0, 0};
		System.out.println(minSum(b));
		
		int[] c = {2, 3, 4, 5, 2};
		System.out.println(minSum(c));
	}
}
