package LargestIncreasingNumberLessThanN;

public class LC738 {
	public static int monotoneIncreasingDigits(int N) {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] <= S[i]) i++;
        while (0 < i && i < S.length && S[i-1] > S[i]) S[--i]--;
        for (int j = i+1; j < S.length; ++j) S[j] = '9';

        return Integer.parseInt(String.valueOf(S));
    }
	
	public static void main(String[] args) {
		System.out.println(monotoneIncreasingDigits(3234));
	}
}
