package Two_Sum_Unique_Pair;

import java.util.*;

public class TwoSum {
	public static int uniquePair(int[] nums, int target) {
		int res = 0;
		Set<Integer> set = new HashSet<>();
		
		for(int n : nums) {
			if(!set.contains(n) && set.contains(target - n)) {
				res++;
			}
			set.add(n);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 1, 2, 45, 46, 46};
		System.out.println(uniquePair(nums1, 47));
		
		int[] nums2 = {1, 1};
		System.out.println(uniquePair(nums2, 2));
		
		int[] nums3 = {1, 5, 1, 5};
		System.out.println(uniquePair(nums3, 6));
	}
}
