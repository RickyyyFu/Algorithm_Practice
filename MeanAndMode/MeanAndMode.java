package MeanAndMode;

import java.util.*;

public class MeanAndMode {
	public static String meanAndMode(int[] arr) {
		int n = arr.length;
		
		Map<Integer, Integer> map = new HashMap<>();
		double sum = 0;
		for(int num : arr) {
			map.put(num, map.getOrDefault(num, 0)+1);
			sum += num;
		}
		
		double mean = sum / n;
		String mean_result = String.format("%.4f", mean);
		//double mean_result = Math.round(mean * 100) * 0.0001d;
		
		int frequency = 0;
		int mode = 0;
		for(int key : map.keySet()) {
			if(frequency < map.get(key)) {
				mode = key;
				frequency = map.get(key);
			}
			else if(frequency == map.get(key)) mode = Math.min(mode, key);
		}
		return mean_result + " " + mode;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,7,3,2};
		int[] b = {4,7,1,3,7,7,7};
		int[] c = {-2,-3,-4,2,3,4};
		System.out.println(meanAndMode(a));
		System.out.println(meanAndMode(b));
		System.out.println(meanAndMode(c));
	}
}
