package IntelligentSubstring;

public class IntelligentSubstring {
	public static int getSpecialSubstring(String s, int k, String charValue) {
		int res = 0;
		
		int left = 0, right = 0;
		int normal = 0;
		while(right < s.length()) {
			if(isNormal(s.charAt(right), charValue)) normal++;
			
			while(left <= right && normal > k) {
				if(isNormal(s.charAt(left), charValue)) normal--;
				left++;
			}
			System.out.println(left + " " + right + " " + normal);
			res = Math.max(res, right-left+1);
			right++;
		}
		return res;
	}
	
	public static boolean isNormal(char c, String charValue) {
		return charValue.charAt(c - 'a') == '0';
	}
	
	public static void main(String[] args) {
		String charValue = "10101111111111111111111111";
		System.out.println(getSpecialSubstring("abcde", 2, charValue));
		System.out.println(getSpecialSubstring("abcde", 1, charValue));
	}
}
