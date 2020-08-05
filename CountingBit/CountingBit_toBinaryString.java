package CountingBit;

import java.util.ArrayList;
import java.util.List;

public class CountingBit_toBinaryString {
	public static List<Integer> countBit(int num){
		List<Integer> list = new ArrayList<>();
		
		String s = Integer.toBinaryString(num);
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
				list.add(i+1);
				count++;
			}
		}
		list.add(0, count);
		
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(countBit(0));
		System.out.println(countBit(161));
	}
}
