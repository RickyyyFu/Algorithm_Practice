package sort_integers_in_matrix;

import java.util.*;

public class Solution {
	class Point{
		int value;
		int freq;
		
		Point(int value, int freq){
			this.value = value;
			this.freq = freq;
		}
	}
	public int[][] sortMatrix(int[][] m){
		if(m == null || m.length == 0) return null;
		
		int[][] res = new int[m.length][m[0].length];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				map.put(m[i][j], map.getOrDefault(m[i][j], 0)+1);
			}
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? a.value - b.value : a.freq - b.freq);
		for(int value : map.keySet()) {
			Point p = new Point(value, map.get(value));
			pq.offer(p);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			int value = p.value;
			int freq = p.freq;
			
			for(int i = 1; i <= freq; i++) {
				list.add(value);
			}
		}
		
		int index = 0;
		for(int i = m.length - 1; i >= 0; i--) {
			for(int j = m[0].length - 1; j >= 0; j--) {
				res[i][j] = list.get(index++);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] m = {
				{0,0,10,0,20,3,4,5},
				{1,2,3,4,1,2,3,4},
				{0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1}
			};
		
		int[][] res = s.sortMatrix(m);
		for(int[] row : res) {
			System.out.println(Arrays.toString(row));
		}
		
	}
}
