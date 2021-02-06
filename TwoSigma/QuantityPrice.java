package TwoSigma;

import java.util.*;

public class QuantityPrice {
	// quantity sorted - binary search
	// O(n)
	public static double getPrice1(int[] q, double[] p, int quantity) {
		ArrayList<Integer> q_arr = new ArrayList<>();
		ArrayList<Double> p_arr = new ArrayList<>();
		for(int i = 0; i < q.length; i++) {
			if(p[i] > 0) {
				q_arr.add(q[i]);
				p_arr.add(p[i]);
			}
		}
		
		if(q_arr.size() == 1) return p_arr.get(0);
		
		int i1 = -1, i2 = -1;
		int x1 = 0, x2 = 0;
		double y1 = 0, y2 = 0;
		if(quantity < q_arr.get(0)) {
			i1 = 0;
			i2 = 1;
		}
		else if(quantity > q_arr.get(q_arr.size()-1)) {
			i1 = q_arr.size()-1;
			i2 = q_arr.size()-2;
		}
		else {
			// binary search
			int left = 0, right = q_arr.size()-1;
			while(left < right) {
				int mid = left + (right-left)/2;
				if(q_arr.get(mid) == quantity) {
					return p_arr.get(mid);
				}
				else if(q_arr.get(mid) > quantity) {
					if(mid > 0 && q_arr.get(mid-1) < quantity) {
						i1 = mid-1;
						i2 = mid;
						break;
					}
					right = mid;
				}
				else if(q_arr.get(mid) < quantity) {
					if(mid < q_arr.size()-1 && q_arr.get(mid+1) > quantity) {
						i1 = mid;
						i2 = mid+1;
						break;
					}
					left = mid + 1;
				}
			}
		}
		x1 = q_arr.get(i1);
		x2 = q_arr.get(i2);
		y1 = p_arr.get(i1);
		y2 = p_arr.get(i2);
		
		return ((y1-y2)*quantity + x1*y2 - x2*y1) / (x1-x2);
	}
	
	// quantity not sorted - treemap
	// O(nlogn)
	public static double getPrice2(int[] q, double[] p, int quantity) {
		TreeMap<Integer, Double> treemap = new TreeMap<>();
		for(int i = 0; i < q.length; i++) {
			if(p[i] > 0) treemap.put(q[i], p[i]);
		}
		
		if(treemap.size() == 1) {
			for(double price : treemap.values()) return price;
		}
		
		if(treemap.containsKey(quantity)) return treemap.get(quantity);
		
		// (x1-x2)*y = (y1-y2)*x+x1y2-x2y1
		int x1 = 0, x2 = 0;
		double y1 = 0, y2 = 0;
		Integer higher = treemap.higherKey(quantity);
		Integer lower = treemap.lowerKey(quantity);
		if(higher != null && lower != null) {
			x1 = higher;
			x2 = lower;
		}
		else if(higher == null) {
			x1 = lower;
			x2 = treemap.lowerKey(x1);
		}
		else if(lower == null) {
			x1 = higher;
			x2 = treemap.higherKey(x1);
		}
		y1 = treemap.get(x1);
		y2 = treemap.get(x2);
		
		double res = ((y1-y2)*quantity + x1*y2 - x2*y1) / (x1-x2);
		return res;
	}
	
	public static void main(String[] args) {
		int[] q = {1, 10, 9};
		double[] p = {1.00, 0, 3.00};
		System.out.println(getPrice1(q, p, 5));
		System.out.println(getPrice1(q, p, 17));
		System.out.println(getPrice2(q, p, 5));
		System.out.println(getPrice2(q, p, 17));
	}
}
