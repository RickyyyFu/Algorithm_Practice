package DecodeString;

import java.util.Stack;

public class DigitCanBeBetweenLetters {
	public static String decodeString(String s) {
		Stack<StringBuilder> s_stack = new Stack<>();
		Stack<Integer> n_stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		String num = "";
		for(int i = 0; i < s.length(); i++){
		    char c = s.charAt(i);
			if(Character.isDigit(c)){
		        num += c;
		        // follow up: check i+1 if end or letter
		        if(i+1 == s.length() || Character.isLetter(s.charAt(i+1))) {
		        	sb.append(num);
		        	num = "";
		        }
			}
			else if(c == '['){
				s_stack.push(sb);
				n_stack.push(Integer.valueOf(num));
				sb = new StringBuilder();
				num = "";
			}
			else if(c == ']'){
				StringBuilder cur = new StringBuilder();
				for(int k = n_stack.pop(); k > 0; k--){ // note: only pop once
			        cur.append(sb);
			    }
			    sb = s_stack.pop().append(cur);
			}
			else{ // c == letter
	            sb.append(c);
	        }
	    }
	    return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("1z3[a2b]a1")); // a2ba2ba2b
	}
}
