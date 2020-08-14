package RemovePalindromePrefix;

public class RemovePalindromePrefix {
	static String str;
	public static String removePalindromePrefix(String s) {
		str = s;
		int prefix_length = 2;
		while(prefix_length >= 2) {
			prefix_length = getPrefixLen(str);
		}	
		return str;
	}
	
	public static int getPrefixLen(String s) {
		int i = s.length()-1;
		while(i >= 0) {
			if(isPalindrome(s, 0 ,i)) break;
			i--;
		}
		if(i+1 >= 2) str = str.substring(i+1);
		return i+1;
	}
	
	public static boolean isPalindrome(String s, int left, int right) {
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(removePalindromePrefix(""));
		System.out.println(removePalindromePrefix("codesingnal"));
		System.out.println(removePalindromePrefix("aaacodedoc"));
	}
}
