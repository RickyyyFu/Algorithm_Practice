package MergeString;

public class MergeString {
	public static String mergeString(String a, String b) {
		if(a == null || a.length() == 0) {
			if(b == null) {
				return "";
			}
			else {
				return b;
			}
		}
		
		int al = a.length();
		int bl = b.length();
		int ai = 0;
		int bi = 0;
		StringBuilder sb = new StringBuilder();
		
		while(ai < al || bi < bl) {
			if(ai < al && bi < bl) {
				sb.append(a.charAt(ai++)).append(b.charAt(bi++));
			}
			else if(ai < al) {
				sb.append(a.charAt(ai++));
			}
			else if(bi < bl) {
				sb.append(b.charAt(bi++));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(mergeString("abc", "def"));
		System.out.println(mergeString("", "def"));
		System.out.println(mergeString("abcz", "defghi"));
	}
}
