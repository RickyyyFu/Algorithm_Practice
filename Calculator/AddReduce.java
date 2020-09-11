package Calculator;

public class AddReduce {
	public static int basicCalculator(String expression) {
		char[] chs = expression.toCharArray();
		int num = 0, sum = 0;
		int sign = 1;
		for(int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if(Character.isDigit(c)) num = num * 10 + Integer.valueOf(String.valueOf(c));
			else if(c == '+' || c == '-') {
				sum += sign * num;
				num = 0;
				sign = (c == '+') ? 1 : -1;
			}
		}
		if(num != 0) sum += sign * num;
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(basicCalculator("1 + 1"));
		System.out.println(basicCalculator("2-1 + 2"));
	}
}
