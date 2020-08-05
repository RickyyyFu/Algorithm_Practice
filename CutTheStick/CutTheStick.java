package CutTheStick;

import java.util.*;

public class CutTheStick {
	public static List<Integer> cutSticks(int[] sticks) {
		List<Integer> list = new ArrayList<>();
		int cur_min = 0;
		int length = sticks.length;
		
		Arrays.sort(sticks);
		int i = 0;
		while(i < length) {
			int idx = i;
			while(idx+1 < length && sticks[idx] == sticks[idx+1]) idx++;
			System.out.print(idx + " ");
			int cut_length = sticks[i] - cur_min;
			list.add(cut_length*(length-i));
			
			cur_min = sticks[i];
			i = idx + 1;
			System.out.println(i);
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,2,3};
		System.out.println(cutSticks(a));
	}
}