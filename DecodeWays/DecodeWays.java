package DecodeWays;

import java.util.Scanner;

/**
 * 
 * different from LC 91, 0-A  25-Z
 *
 */
public class DecodeWays {
	public static int numDecoding(String s) {
		if(s== null || s.length() == 0) return 0;
		
		int[] dp = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = 1; // diff 1, cuz 0 -> A
		
		for(int i = 2; i <= s.length(); i++) {
			// one-digit
			dp[i] += dp[i-1]; // diff 2, 0 -> A
			
			// two-digit
			int twoDigit = Integer.parseInt(s.substring(i-2, i));
			if(twoDigit >= 10 && twoDigit <= 25) dp[i] += dp[i-2];
		}
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.print(numDecoding(s));
		scanner.close();
	}
}
