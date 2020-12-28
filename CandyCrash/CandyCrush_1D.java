package CandyCrash;

import java.util.Stack;

// stack<Pair<char, int>>
public class CandyCrush_1D {
	static class Pair{
		char c;
		int cnt;
		
		public Pair(char c, int n) {
			this.c = c;
			this.cnt = n;
		}
	}
	
	public static String remove(String s) {
		if(s == null || s.length() <= 2) return s;
		
		Stack<Pair> stack = new Stack<>();
		int i = 0;
		while(i < s.length()) {
			if(stack.isEmpty() || stack.peek().c != s.charAt(i)) {
				stack.push(new Pair(s.charAt(i), 1));
				i++;
				//continue;
			}
			
			while(i < s.length() && stack.peek().c == s.charAt(i)) {
				Pair pair = stack.pop();
				stack.push(new Pair(pair.c, pair.cnt+1));
				i++;
			}
			
			while(!stack.isEmpty() && stack.peek().cnt >= 3) {
				stack.pop();
			}
		}
		
		if(stack.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.insert(0, stack.pop().c);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(remove("")); //
		System.out.println(remove("abc")); //abc
		System.out.println(remove("aaa")); //
		System.out.println(remove("aaaabbbc")); //c
		System.out.println(remove("aabbbacd")); //cd
		System.out.println(remove("aabbccddeeedcba")); //blank expected
		System.out.println(remove("aabbbaacd")); //cd
		System.out.println(remove("dddabbbbaccccaax")); //x
	}
}
