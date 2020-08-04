package ChangePalindrome;

public class ChangePalindrome {
	public static boolean isPalindrome(char[] chars) {
		int left = 0;
		int right = chars.length - 1;
		while(left < right) {
			if(chars[left] != chars[right]) return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static String changePalindrome(String s) {
		char[] chars = s.toCharArray();
		int idx = 0;
		
		while(idx < chars.length) {
			while(chars[idx] > 'a') {
				chars[idx] -= 1;
				if(!isPalindrome(chars)) return new String(chars);
			}
			idx++;
		}
		return "IMPOSSIBLE";
	}
	
	public static void main(String[] args) {
		String a = "";
		String b = "aba";
		String c = "abba";
		System.out.println(changePalindrome(a));
		System.out.println(changePalindrome(b));
		System.out.println(changePalindrome(c));
	}
}
