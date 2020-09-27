package DigitCalculate;

public class EvenReduce_OddAdd {
	public static int calculate(int n) {
		String s = String.valueOf(n);
		int res = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int cur = s.charAt(i) - '0';
			if(i % 2 == 0) res += cur;
			else res -= cur;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(calculate(12345));
		System.out.println(calculate(2345));
	}
}
