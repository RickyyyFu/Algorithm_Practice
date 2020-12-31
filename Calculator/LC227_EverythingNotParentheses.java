package Calculator;

import java.util.Stack;

// + - * /

// preNum
public class LC227_EverythingNotParentheses {
	public static int calculate(String s) {
    	if(s == null || s.length() == 0) return 0;
    	
    	int sum = 0;
    	int preNum = 0;
    	int curNum = 0;
    	char operate = '+';
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(Character.isDigit(c)) {
    			curNum = curNum*10 + (c-'0');
    		}
    		if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length()-1) {
    			// ...pre +/- cur (c)...
    			if(operate == '+' || operate == '-') {
    				sum += preNum;
    				preNum = (operate == '+') ? curNum : -curNum;
    			}
    			// ...pre * cur (c)...
    			else if(operate == '*') {
    				preNum = preNum * curNum;
    			}
    			// ...pre / cur (c)...
    			else if(operate == '/') {
    				preNum = preNum / curNum;
    			}
    			curNum = 0;
    			operate = c;
    		}
    	}
    	sum += preNum;
		
		return sum;
    }
    
    // stack
    /*
     public static int calculate(String s) {
    	if(s == null || s.length() == 0) return 0;
    	
    	int sum = 0;
    	Stack<Integer> stack = new Stack<>();
    	int curNum = 0;
    	char operate = '+';
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(Character.isDigit(c)) {
    			curNum = curNum*10 + (c-'0');
    		}
    		if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length()-1) {
    			if(operate == '+') {
    				stack.push(curNum);
    			}
    			else if(operate == '-') {
    				stack.push(-curNum);
    			}
    			else if(operate == '*') {
    				stack.push(stack.pop()*curNum);
    			}
    			else if(operate == '/') {
    				stack.push(stack.pop()/curNum);
    			}
    			curNum = 0;
        		operate = c;
    		}
    	}
    	
    	while(!stack.isEmpty()) {
    		sum += stack.pop();
    	}
    	
    	return sum;
    }
    */
    public static void main(String[] args) {
    	System.out.println(calculate(" 3/ 2 "));
    	System.out.println(calculate(" 3+5 / 2 "));
    }
}
