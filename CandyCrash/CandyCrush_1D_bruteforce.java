package CandyCrash;

// brute force - O(n^2)	O(1)

public class CandyCrush_1D_bruteforce {
	public static String remove_bf(String s) {
		if(s == null || s.length() <= 2) return s;
		
		StringBuilder sb = new StringBuilder(s); // O(1)
		boolean hasCrush = true;
		
		// at most scan O(n/k) times; k >= 3
		while(hasCrush) {
			hasCrush = false;
			
			// O(n)
			int count = 1;
			int i = 0;
			while(i < sb.length()) { // for loop maybe i++ wrongly
				if(i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
					count = 1;
					i++;
				}
				while(i < sb.length() && sb.charAt(i) == sb.charAt(i-1)) {
					count++;
					//System.out.println(sb.charAt(i) + " " + count);
					i++;
				}
				
				if(count >= 3) {
					hasCrush = true;
					sb.delete(i-count, i);
				}
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(remove_bf("")); //
		System.out.println(remove_bf("abc")); //abc
		System.out.println(remove_bf("aaa")); //
		System.out.println(remove_bf("aaaabbbc")); //c
		System.out.println(remove_bf("aabbbacd")); //cd
		System.out.println(remove_bf("aabbccddeeedcba")); //blank expected
		System.out.println(remove_bf("aabbbaacd")); //cd
		System.out.println(remove_bf("dddabbbbaccccaax")); //x
	}

}
