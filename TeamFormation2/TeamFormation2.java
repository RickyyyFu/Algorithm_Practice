package TeamFormation2;

public class TeamFormation2 {
	public static int countTeams(int[] skills, int k, int l, int r) {
		int candidate = 0;
		for(int skill : skills) {
			if(l <= skill && skill <= r) candidate++;
		}
		
		int res = 0;
		for(int i = k; i <= candidate; i++) {
			res += nCk(candidate, i);
		}
		
		return res;
	}
	
	// nCk = (n!) / ((n-k)!*k!)
	public static int nCk(int n, int k) {
		return (int)(factorial(n) / (factorial(n-k) * factorial(k)));
	}
	
	public static long factorial(int n) {
		long ans = 1;
		for(int i = 2; i <= n; i++) ans *= i;
		return ans;
	}
	
	public static void main(String[] args) {
		int[] s1 = {12,4,6,13,5,10};
		System.out.println(countTeams(s1, 3, 4, 10));
	}
}
