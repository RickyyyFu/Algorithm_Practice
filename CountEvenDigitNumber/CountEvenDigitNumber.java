package CountEvenDigitNumber;

public class CountEvenDigitNumber {
	public static int countEvenDigit(int[] arr) {
		int res = 0;
		for(int num : arr) {
			if(isEvenDigit(num)) res++;
		}
		return res;
	}
	
	public static boolean isEvenDigit(int num) {
		if(num == 0) return false;
		
		int digit = 0;
		while(num > 0) {
			num /= 10;
			digit++;
		}
		return digit % 2 == 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,0,123,124};
		System.out.println(countEvenDigit(arr));
	}
}
