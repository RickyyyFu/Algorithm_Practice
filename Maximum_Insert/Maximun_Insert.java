package Maximum_Insert;

public class Maximun_Insert {
	public static int solution(String s) {
		// two pointer 
		// find the number N of consecutive 'a' between two characters non-'a'
		// add 2 - N 'a' on above position
		if(s == null || s.length() == 0) return 2;
		
		int res = 0;
		int first = -1; // start with -1 (non-'a')
		for(int second = 0; second < s.length(); second++) {
			if(s.charAt(second) != 'a') {
				// more than 3 consecutive 'a'
				if(second - first > 3) {
					return -1;
				}
				else {
					res = res + (2 - (second - first - 1));
					first = second;
				}
			}
			else {
				// more than 3 consecutive 'a'
				if(second - first == 3) {
					return -1;
				}
			}
		}
		// second reaches the end
		res = res + (2 - (s.length() - first - 1));
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("aabab"));
		System.out.println(solution("dog"));
		System.out.println(solution("aa"));
		System.out.println(solution("baaaa"));
		System.out.println(solution(""));
		System.out.println(solution("a"));
		System.out.println(solution("aaabaaa"));
	}
}
