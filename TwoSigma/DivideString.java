package TwoSigma;

// or BigInteger			a.divide(b)

public class DivideString {
	public static String divide(String num, int divisor) {
		int n = num.length();
		char[] dividend = num.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for(int i = 0; i < n; i++) {
			int x = carry*10 + dividend[i] - '0';
			sb.append(x / divisor);
			carry = x % divisor;
		}
		
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) != '0') return sb.substring(i); 
		}
		return "";
	}
	
	 public static void main(String[] args) { 
		 String number = "1248163264128256512"; 
		 int divisor = 125; 
		 System.out.println(divide(number, divisor)); 
	 }  
}
