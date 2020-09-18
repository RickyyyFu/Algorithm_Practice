package LargestIncreasingNumberLessThanN;

public class NotSameDigit {
	public static int notSameDigits(int N) {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] <= S[i]) i++;
        while (0 < i && i < S.length && S[i-1] >= S[i]) S[--i]--;
        for (int j = i+1; j < S.length; ++j) S[j] = '9';
        
        char cur = '9';
        for(int k = S.length-1; k >= 0; k--) {
        	if(S[k] >= cur) S[k] = cur--;
        }
        return Integer.parseInt(String.valueOf(S));
    }
	
	
	public static void main(String[] args) {
		System.out.println(notSameDigits(99998));
	}
}
