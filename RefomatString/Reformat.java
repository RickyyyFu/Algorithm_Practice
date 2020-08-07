package RefomatString;

public class Reformat {
	public static String reformatstring(String s, int[] sizes) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int p = 0;
		while(i < sizes.length) {
			if(i + 1 == sizes.length) {
				sb.append(s.substring(p));
				return sb.toString();
			}
			String pre = s.substring(p, p+sizes[i]);
			p += sizes[i]; 
			String post = s.substring(p, p+sizes[i+1]);
			p += sizes[i+1];
			
			sb.append(post).append(pre);
			
			i += 2;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] sizes = {3, 2, 2, 1, 1};
		String s = "abcdefghi";
		System.out.println(reformatstring(s, sizes));
		int[] sizes1 = {3, 2, 2, 1, 1, 2};
		String s1 = "abcdefghijk";
		System.out.println(reformatstring(s1, sizes1));
	}
}
