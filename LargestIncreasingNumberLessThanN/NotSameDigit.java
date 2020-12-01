package LargestIncreasingNumberLessThanN;

public class NotSameDigit {
	public static int notSameDigits(String N) {
        char[] S = N.toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] < S[i]) i++;
        while (0 < i && i < S.length && S[i-1] >= S[i]) S[--i]--;
        for (int j = i+1; j < S.length; ++j) S[j] = '9';
        
       // System.out.print(String.valueOf(S));
        char cur = '9';
        for(int k = S.length-1; k >= 0; k--) {
        	if(S[k] >= cur) S[k] = cur;
        	if(cur > '0') cur--;
        }
        return Integer.parseInt(String.valueOf(S));
    }
	
	
	public static void main(String[] args) {
		System.out.println(notSameDigits("99998"));
		System.out.println(notSameDigits("11180"));  // 11179 wrong(mark is wrong)  ->	6789
		System.out.println(notSameDigits("10001"));
		System.out.println(notSameDigits("11999"));
		System.out.println(notSameDigits("240000000"));
		System.out.println(notSameDigits("100000000000"));
	}
}
