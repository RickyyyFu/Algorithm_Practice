package TwoSigma;

import java.util.*;

/**
 ** 给cities，city的坐标，求每个city的最近city, condition on 同一个x或者y。implementation还是比较复杂的
 * 
 * sort? O(NlogN)
 */

public class NearestCities {
	// brute force O(n^2)
	public static int[][] findNearest1(int[][] points){
		int[][] res = new int[points.length][2];
		
		for(int i = 0; i < points.length; i++) {
			res[i][0] = Integer.MAX_VALUE;
			res[i][1] = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < points.length; j++) {
				if(points[i][0] == points[j][0] && points[i][1] != points[j][1]) {
					if(Math.abs(points[i][1]-points[j][1]) < min) {
						min = Math.abs(points[i][1]-points[j][1]);
						res[i][0] = points[j][0];
						res[i][1] = points[j][1];
					}
				}
				if(points[i][1] == points[j][1] && points[i][0] != points[j][0]) {
					if(Math.abs(points[i][0]-points[j][0]) < min) {
						min = Math.abs(points[i][0]-points[j][0]);
						res[i][0] = points[j][0];
						res[i][1] = points[j][1];
					}
				}
			}
		}
		return res;
	}
	
	// sort O(nlogn)
	public static int[][] findNearest2(int[][] points){
		if(points.length <= 1) return points;
		int n = points.length;
		
		int[][] res = new int[n][2];
		for(int i = 0; i < n; i++) {
			res[i][0] = Integer.MAX_VALUE;
			res[i][1] = Integer.MAX_VALUE;
		}
		
		Map<int[], Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			map.put(points[i], i);
		}
		
		// sort by x
		Arrays.sort(points, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
		for(int i = 0; i <= n-1; i++) {
			int idx = map.get(points[i]);
			int min = Integer.MAX_VALUE;
			if(res[idx][0] == points[i][0]) {
				min = Math.min(min, Math.abs(res[idx][1]-points[i][1]));
			}
			if(res[idx][1] == points[i][1]) {
				min = Math.min(min, Math.abs(res[idx][0]-points[i][0]));
			}
			
			// compare with left one
			if(i > 0 && points[i][0] == points[i-1][0]) {
				if(points[i][1]-points[i-1][1] < min) {
					res[idx][0] = points[i-1][0];
					res[idx][1] = points[i-1][1];
					min = points[i][1]-points[i-1][1];
				}
			}
			// compare with right one
			if(i < n-1 && points[i][0] == points[i+1][0]) {
				if(points[i+1][1]-points[i][1] < min) {
					res[idx][0] = points[i+1][0];
					res[idx][1] = points[i+1][1];
					min = points[i+1][1]-points[i][1];
				}
			}
		}
		
		// sort by y
		Arrays.sort(points, (a,b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
		for(int i = 1; i <= n-2; i++) {
			int idx = map.get(points[i]);
			int min = Integer.MAX_VALUE;
			if(res[idx][0] == points[i][0]) {
				min = Math.min(min, Math.abs(res[idx][1]-points[i][1]));
			}
			if(res[idx][1] == points[i][1]) {
				min = Math.min(min, Math.abs(res[idx][0]-points[i][0]));
			}
			
			// compare with left one
			if(i > 0 && points[i][1] == points[i-1][1]) {
				if(points[i][0]-points[i-1][0] < min) {
					res[idx][0] = points[i-1][0];
					res[idx][1] = points[i-1][1];
					min = points[i][0]-points[i-1][0];
				}
			}
			// compare with right one
			if(i < n-1 && points[i][1] == points[i+1][1]) {
				if(points[i+1][0]-points[i][0] < min) {
					res[idx][0] = points[i+1][0];
					res[idx][1] = points[i+1][1];
					min = points[i+1][0]-points[i][0];
				}
			}
		}
		
		return res;
	}
	
	// general
	// Map + TreeSet O(NlogN)
	public static int[][] findNearest3(int[][] points){
		Map<Integer, TreeSet<Integer>> mx = new HashMap<>();
		Map<Integer, TreeSet<Integer>> my = new HashMap<>();
		for(int[] p : points) {
			int x = p[0];
			int y = p[1];
			if(!mx.containsKey(x)) mx.put(x, new TreeSet<Integer>());
//			Set<Integer> set = mx.get(x);
//			set.add(y);
			mx.get(x).add(y);
			if(!my.containsKey(y)) my.put(y, new TreeSet<Integer>());
//			set = my.get(y);
//			set.add(x);
			my.get(y).add(x);
		}
		
		int n = points.length;
		int[][] res = new int[n][2];
		for(int i = 0; i < n; i++) {
			res[i][0] = Integer.MAX_VALUE;
			res[i][1] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			if(mx.containsKey(points[i][0])) {
				Integer higher = mx.get(points[i][0]).higher(points[i][1]);
				Integer lower = mx.get(points[i][0]).lower(points[i][1]);
				if(higher != null && min > higher-points[i][1]) {
					min = higher-points[i][1];
					res[i][0] = points[i][0];
					res[i][1] = higher;
				}
				if(lower != null && min > points[i][1]-lower) {
					min = points[i][1]-lower;
					res[i][0] = points[i][0];
					res[i][1] = lower;
				}
			}
			if(my.containsKey(points[i][1])) {
				Integer higher = my.get(points[i][1]).higher(points[i][0]);
				Integer lower = my.get(points[i][1]).lower(points[i][0]);
				if(higher != null && min > higher-points[i][0]) {
					min = higher-points[i][0];
					res[i][0] = higher;
					res[i][1] = points[i][1];
				}
				if(lower != null && min > points[i][0]-lower) {
					min = points[i][0]-lower;
					res[i][0] = lower;
					res[i][1] = points[i][1];
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] p1 = {{0,1}, {0,3}, {0,2}, {5,1}, {11,1}, {10,10}};
		int[][] r1 = findNearest1(p1);
		for(int[] r : r1) {
			System.out.print("(" + r[0] + " " + r[1] + ")");
		}
		
		int[][] p2 = {{0,1}, {0,3}, {0,2}, {5,1}, {11,1}, {10,10}};
		int[][] r2 = findNearest2(p2);
		for(int[] r : r2) {
			System.out.print("(" + r[0] + " " + r[1] + ")");
		}
		
		int[][] p3 = {{0,1}, {0,3}, {0,2}, {5,1}, {11,1}, {10,10}};
		int[][] r3 = findNearest3(p3);
		for(int[] r : r3) {
			System.out.print("(" + r[0] + " " + r[1] + ")");
		}
	}
}
