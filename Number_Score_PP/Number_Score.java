package Number_Score_PP;

public class Number_Score {
	public static int compute_number_score(int num) {
		int s1 = computeByRule1(num);
		int s2 = computeByRule2(num);
		int s3 = computeByRule3(num);
		int s4 = computeByRule4(num);
		int s5 = computeByRule5(num);
		
		return s1 + s2 + s3 + s4 + s5;
	}
	
	static int computeByRule1(int num) {
		int score = 0;
		char[] digits = Integer.toString(num).toCharArray();
		
		for(char c : digits) {
			if(c == '7') {
				score += 1;
			}
		}
		return score;
	}
	
	static int computeByRule2(int num) {
		int score = 0;
		char[] digits = Integer.toString(num).toCharArray();
		
		for(int i = 1; i < digits.length; i++) {
			if(digits[i] == '5' && digits[i - 1] == '5') {
				score += 3;
			}
			
//			int j = i;
//			while(digits[j] == '5' && digits[j - 1] == '5') {
//				score += 3;
//				j++;
//			}
		}
		
		
		return score;
	}
	
	static int computeByRule3(int num) {
		int score = 0;
		char[] digits = Integer.toString(num).toCharArray();
		
		int curLen = 1;
		for(int i = 1; i < digits.length; i++) {
			if(digits[i] == digits[i - 1] - 1) {
				curLen++;
			}
			else {
				score += curLen * curLen;
				curLen = 1;
			}
		}
		score += curLen * curLen;
		return score;
	}
	
	static int computeByRule4(int num) {
		int score = 0;
		if(num % 3 == 0) {
			score = 2;
		}
		return score;
	}
	
	static int computeByRule5(int num) {
		int score = 0;
		char[] digits = Integer.toString(num).toCharArray();
		
		for(char c : digits) {
			int digit = c - '0';
			if(digit % 2 == 0) {
				score += 4;
			}
		}
		return score;
	}
	
	public static void main(String[] args) {
		System.out.println(computeByRule1(7571));
		System.out.println(computeByRule2(355553));
		System.out.println(computeByRule3(9765320));
		System.out.println(computeByRule4(9));
		System.out.println(computeByRule5(10000));
	}
}
