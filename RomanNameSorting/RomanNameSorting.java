package RomanNameSorting;

import java.util.*;

public class RomanNameSorting {
	public static List<String> sortName(List<String> names){
		TreeMap<String, PriorityQueue<String>> treemap = new TreeMap<>();
		for(String name : names) {
			String[] info = name.split(" ");
			String letter = info[0];
			String num = info[1];
			// int number = romanToInt(info[1]);
			if(!treemap.containsKey(letter)) {
				treemap.put(letter, new PriorityQueue<String>((a, b) -> (romanToInt(a) - romanToInt(b))));
			}
			treemap.get(letter).offer(num);
		}
		
		List<String> res = new ArrayList<>();
		for(String key : treemap.keySet()) {
			PriorityQueue<String> pq = treemap.get(key);
			for(String n : pq) {
				String ans = key + " " + n;
				res.add(ans);
			}
		}
		return res;
	}
	
	static Map<String, Integer> map = new HashMap<>();
	static {
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
	}
	
	public static int romanToInt(String roman) {
		int sum = 0;
		int i = 0;
		while(i < roman.length()) {
			String curSymbol = roman.substring(i, i+1);
			int curVal = map.get(curSymbol);
			int nextVal = 0;
			
			if(i+1 < roman.length()) {
				String nextSymbol = roman.substring(i+1, i+2);
				nextVal = map.get(nextSymbol);
			}
			
			if(curVal < nextVal) {
				sum += (nextVal - curVal);
				i += 2;
			}
			else {
				sum += curVal;
				i += 1;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Steven XL");
		list.add("Steven XVI");
		list.add("David IX");
		list.add("Mary XV");
		list.add("Mary XIII");
		list.add("Mary XX");
		list.add("Mary XX");
		
		System.out.println(sortName(list));
		System.out.println(sortName1(list));
	}
	
	
	
	public static List<String> sortName1(List<String> names){
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 0);
		map.put('V', 1);
		map.put('X', 2);
		map.put('L', 3);
		
		Collections.sort(names, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				String[] a = s1.split(" ");
				String[] b = s2.split(" ");
				if(!a[0].equals(b[0])){
					return a[0].compareTo(b[0]);
				}
				else{
					int len = Math.min(a[1].length(), b[1].length());
					
					for(int i = 0; i < len; i++){
						int res = map.get(a[1].charAt(i)) - map.get(b[1].charAt(i));
						if(res != 0) return res;
						continue;
					}
					return a[1].length() - b[1].length();
				}
			}
		});
		return names;
	}

}
