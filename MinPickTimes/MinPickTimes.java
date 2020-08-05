package MinPickTimes;

import java.util.Arrays;

public class MinPickTimes {
	public static int minTimes(double[] items) {
		int res = 0;
		Arrays.sort(items);
		
		int idx = 0;
		while(idx < items.length) {
			int k = idx;
			int sum = 0;
			while(k < items.length && sum + items[k] <= 3) {
				sum += items[k];
				k++;
			}
			res++;
			idx = k;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		double[] items = {1.01, 1.01, 1.99, 2.5};
		System.out.println(minTimes(items));
	}
}
