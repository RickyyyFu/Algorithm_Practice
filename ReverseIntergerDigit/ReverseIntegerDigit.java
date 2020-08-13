package ReverseIntergerDigit;

public class ReverseIntegerDigit {
	public static int reverseInt(int num) {
		char[] chs = String.valueOf(num).toCharArray();
		
		for(int i = 0; i < chs.length; i++) {
			if(i+1 == chs.length) continue;
			char tmp = chs[i];
			chs[i] = chs[i+1];
			chs[i+1] = tmp;
		}
		
		return Integer.valueOf(new String(chs));
	}
	
	public static void main(String[] args) {
		System.out.println(reverseInt(123));
		System.out.println(reverseInt(1023));
	}
}
