package CountingBit;

import java.util.*;

public class CountingBit_BitMask {
	public static List<Integer> countBit(int num){
		List<Integer> list = new ArrayList<>();

		int count = 0;
		int length = 0;
		while(num > 0) {
			if((num & 1) == 1) {
				list.add(0, length);
				count++;
			}
			num >>= 1;
			length++;
		}
		
		for(int i = 0; i < list.size(); i++) {
			list.set(i, length-list.get(i));
		}
		list.add(0, count);
		
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(countBit(0));
		System.out.println(countBit(161));
	}
}
