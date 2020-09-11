package Calculator;

import java.util.Stack;

public class WithParentheses {
	public static int calculatorParentheses(String expression) {
		char[] chs = expression.toCharArray();
		Stack<Integer> stack = new Stack<>();
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
			else if(c == '(') {
				stack.push(sum);
				stack.push(sign);
				num = 0;
				sum = 0;
				sign = 1;
			}
			else if(c == ')') {
				sum += sign * num;
				sum = sum * stack.pop() + stack.pop();
				num = 0;
			}
		}
		if(num != 0) sum += sign * num;
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(calculatorParentheses("(1+(4+5+2)-  3)+( 6 + 8)"));
	
	}
}
