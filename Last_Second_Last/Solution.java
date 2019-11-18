package Last_Second_Last;

public class Solution {
	public static String solution(String s) {
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(length - 1)).append(" ").append(s.charAt(length - 2));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution("bat"));
		System.out.println(solution("APPLE"));
	}
}
