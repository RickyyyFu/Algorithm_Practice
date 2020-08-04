/**
 * geeksforgeeks.org/minimum-incrementdecrement-to-make-array-non-increasing/
 * 
 * PriorityQueue
 */

package ClimbTheHill;

import java.util.*;

public class ClimbTheHill {
	public static int climbTheHill(int[] arr) {
		// descending
		int res1 = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int num : arr) {
			if(!minHeap.isEmpty() && minHeap.peek() < num) {
				int diff = num - minHeap.peek();
				res1 += diff;
				minHeap.poll();
			}
			minHeap.offer(num);
		}
		
		// ascending
		int res2 = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
		for(int num : arr) {
			if(!maxHeap.isEmpty() && maxHeap.peek() > num) {
				int diff = maxHeap.peek() - num;
				res2 += diff;
				maxHeap.poll();
			}
			maxHeap.offer(num);
		}
		
		return Math.min(res1, res2);
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,2,5,5,4,4};
		System.out.println(climbTheHill(a)); // #2
		int[] b = {7,5,6,5,2,1,0};
		System.out.println(climbTheHill(b)); // #1
		int[] c = {9,8,7,2,3,3};
		System.out.println(climbTheHill(c)); // #1
		int[] d = {1,5,5,5};
		System.out.println(climbTheHill(d)); // #0
		int[] e = {0,1,2,6,5,7};
		System.out.println(climbTheHill(e)); // #1
	}
}
