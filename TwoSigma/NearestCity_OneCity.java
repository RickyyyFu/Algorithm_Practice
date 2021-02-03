package TwoSigma;

import java.util.*;

public class NearestCity_OneCity {
	public static char findNearest_OneCity(char[] pn, int[][] points, int[] p){
		Map<int[], Integer> piMap = new HashMap<>();
		for(int i = 0; i < points.length; i++) {
			piMap.put(points[i], i);
		}
		Map<Integer, Character> pnMap = new HashMap<>();
		for(int i = 0; i < pn.length; i++) {
			pnMap.put(i, pn[i]);
		}
		
		int x = p[0];
		int y = p[1];
		char res = ' ';
		int min = Integer.MAX_VALUE;
		for(int[] point : points) {
			if(point[0] == x && point[1] != y) {
				if(Math.abs(point[1]-y) < min) {
					min = Math.abs(point[1]-y);
					res = pnMap.get(piMap.get(point));
				}
			}
			if(point[1] == y && point[0] != x) {
				if(Math.abs(point[0]-x) < min) {
					min = Math.abs(point[0]-x);
					res = pnMap.get(piMap.get(point));
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] p = {{0,1}, {0,3}, {0,2}, {5,1}, {11,1}, {10,10}};
		char[] pn = {'a', 'b', 'c', 'd', 'e', 'f'};
		for(int[] point : p) {
			System.out.print(findNearest_OneCity(pn, p, point) + " ");
		}
		
	}
}
