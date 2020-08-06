package LimitedChangeToBalance;

public class LimitedChangeToBalance {
	public static boolean canChange(String s, int k) {
		int deleteLeft = 0;
		int deleteRight = 0;
		for(char c : s.toCharArray()) {
			if(c == '<') deleteLeft++;
			else {
				if(deleteLeft > 0) deleteLeft--;
				else deleteRight++;
			}
		}
		return deleteLeft + deleteRight <= k;
	}
	
	public static void main(String[] args) {
		System.out.println(canChange("<>", 1));
		System.out.println(canChange("<", 1));
		System.out.println(canChange("><", 1));
		System.out.println(canChange("<><", 1));
		System.out.println(canChange("<><<", 1));
		System.out.println(canChange("", 1));
	}
}
