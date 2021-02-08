package TwoSigma;

import java.util.*;

/**
	if only find one day's nearest day, extend(<- i ->)  O(n)
 */

// return array
// brute force  O(n^2)
// two mono-stack	O(n)
// LC 503
public class StockGame {
	public static int[] getNearestSmall(int[] p) {
		int[] res = new int[p.length];
		Arrays.fill(res, -1);
		if(p.length <= 1) return res;
		
		Stack<Integer> s1 = new Stack<Integer>();
		// ascending
		for(int i = 0; i < p.length; i++) {
			while(!s1.isEmpty() && p[s1.peek()] > p[i]) {
				int preIdx = s1.pop();
				res[preIdx] = res[preIdx] == -1 ? i : Math.min(res[preIdx], i);
			}
			s1.push(i);
		}
		
		Stack<Integer> s2 = new Stack<Integer>();
		// ascending
		for(int i = 0; i < p.length; i++) {
			while(!s2.isEmpty() && p[s2.peek()] >= p[i]) {
				s2.pop();
			}
			if(!s2.isEmpty()) {
				if(res[i] == -1) res[i] = s2.peek();
				else res[i] = Math.min(res[i], s2.peek());
			}
			s2.push(i);
		}
		for(int n : res) System.out.print(n + " ");
		System.out.println();
		return res;
	}
	
	public static void main(String[] args) {
		int[] p1 = {1,2,3,2,5,7,8,1}; // {-1,0,1,0,3,4,5,-1};
		getNearestSmall(p1);
		
		int[] p2 = {1,1,1,1,1,1,1,1}; // {-1,-1,-1,-1,-1,-1,-1,-1};
		getNearestSmall(p2);
		
		int[] p3 = {1,0,0,0}; // {1,-1,-1,-1};
		getNearestSmall(p3);
		
		int[] p4 = {1,0,0,1}; // {1,-1,-1,2};
		getNearestSmall(p4);
		
		int[] p5 = {1}; // {-1};
		getNearestSmall(p5);
		
		int[] p6 = {1,2,3,4,5}; // {-1,0,1,2,3};
		getNearestSmall(p6);
	}
}
