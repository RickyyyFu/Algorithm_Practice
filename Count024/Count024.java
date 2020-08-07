package Count024;

public class Count024 {
	public static int count024(int n) {
		int res = 0;
		for(int num = 0; num <= n; num++) {
			res += counteach(num);
		}
		return res;
	}
	
	public static int counteach(int num) {
		if(num == 0) return 1;
		int ans = 0;
		while(num > 0) {
			int digit = num % 10;
			if(digit == 0) ans++;
			if(digit == 2) ans++;
			if(digit == 4) ans++;
			num /= 10;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(count024(11));
		System.out.println(count024(99));
		System.out.println(count024(999));
	}
}
