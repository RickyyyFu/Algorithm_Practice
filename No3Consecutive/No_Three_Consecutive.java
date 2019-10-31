package No3Consecutive;

public class No_Three_Consecutive {
	public static String solution(String s) {
		if(s == null || s.length() < 3) return s;
		
		StringBuilder sb = new StringBuilder();
		char cur = ' ';
		int count = 0;
		for(char c : s.toCharArray()) {
			if(c == cur) {
				count++;
			}
			else {
				cur = c;
				count = 1;
			}
			
			if(count < 3) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.print(solution("xxxtxxx"));
	}
}
