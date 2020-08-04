/**
 *	Note: distinct!!!!!!!!!!!!!!!
 */

package EvenSubarray;

import java.util.*;

public class EvenSubarray {
	public static int evenSubarray(int[] numbers, int k) {
		Set<List<Integer>> set = new HashSet<>();
		
		int left = 0;
		int right = left;
		int subOddCount = 0;
		int res = 0;
		
		while(right < numbers.length) {
			int num = numbers[right];
			
			if(num % 2 == 1) subOddCount++;
			if(subOddCount > k){
				while(numbers[left] % 2 == 0) left++; // skip all even num, move left pointer to right until find the next odd

				left++; // move left again to exclude the left odd number from subarray
				subOddCount--;
			}
			// res += (right-left+1);  // get the number of subarray that ends with the right
			
			// all subarrays that ends with the right
			for(int i = left; i <= right; i++) {
				List<Integer> list = new ArrayList<>();
				for(int idx = i; idx <= right; idx++) list.add(numbers[idx]);
				set.add(list);
			}
			
			
			right++;
		}
		// return res;
		System.out.print(set);
		return set.size();
	}

	public static void main (String[] args){ 
		int a[] = { 2, 2, 5, 6, 9, 2, 11 };
		System.out.println(evenSubarray(a, 1));   // 17		15 (5+)
		
		int b[] = {1, 2, 3, 4}; 
		System.out.println(evenSubarray(b, 1));   // 8		8
		System.out.println(evenSubarray(b, 2));   // 10		10
		System.out.println(evenSubarray(b, 3));   // 10		10
		
		int c[] = {1, 2, 3, 3}; 
		System.out.println(evenSubarray(c, 1));   // 6		5
		
		int[] d = {1,2,2,3,3,4};
		System.out.println(evenSubarray(d, 1));   // 12		10
	} 
}
