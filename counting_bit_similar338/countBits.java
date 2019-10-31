package counting_bit_similar338;

import java.util.*;

public class countBits {
	public static List<Integer> countBits(int num){
		List<Integer> res = new ArrayList<>();
		
		int count = 0;
		int index = 1;
		while(num != 0) {
			if((num & 1) == 1) {
				count++;
				res.add(0, index);
			}
			num >>= 1;
			index++;
		}
		
		for(int i = 0; i < res.size(); i ++) {
			res.set(i, index - res.get(i));
		}
		res.add(0, count);
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(countBits(161));
	}
}
