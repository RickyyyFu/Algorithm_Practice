package CutTheStick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheStick_VM {
	public static List<Integer> cutSticks(int[] sticks) {
		List<Integer> list = new ArrayList<>();
		int length = sticks.length;
		int[] buckets = new int[1000];
		for(int stick : sticks) buckets[stick]++;
		
		int account = length;
		list.add(account);
		for(int l : buckets) {
			if(l != 0) {
				account -= l;
				if(account > 0) list.add(account);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,2,3};
		System.out.println(cutSticks(a));
	}
}
