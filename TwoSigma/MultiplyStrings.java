package TwoSigma;

public class MultiplyStrings {
	public static String multiplyString(String a, String b) {
		if(a == null || b == null || a.length() == 0 || b.length() == 0) return null;
		
		boolean negative = false;
		if(a.charAt(0) == '-') {
			negative = !negative;
			a = a.substring(1);
		}
		if(b.charAt(0) == '-') {
			negative = !negative;
			b = b.substring(1);
		}
		
		int[] res = new int[a.length()+b.length()];
		for(int i = a.length()-1; i >= 0; i--) {
			for(int j = b.length()-1; j >= 0; j--) {
				int x = a.charAt(i) - '0';
				int y = b.charAt(j) - '0';
				int sum = x*y + res[i+j+1];
				
				res[i+j+1] = sum % 10;
				res[i+j] += sum / 10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : res) {
			if(sb.length() == 0 && n == 0) continue;
			sb.append(n);
		}
		if(sb.length() == 0) return "0";
		if(negative) sb.insert(0, "-");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(multiplyString("123", "456"));
		System.out.println(multiplyString("-123", "-456"));
		System.out.println(multiplyString("123", "-456"));
		System.out.println(multiplyString("-123", "-0"));
	}
}
