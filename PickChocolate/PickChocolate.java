package PickChocolate;

public class PickChocolate {
	public static int getChocoMax(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n+1];
		dp[1] = arr[0];
		for(int i = 2; i <= n; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i-1]);
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int[] a = {5, 30, 99, 60, 5, 10};
		System.out.println(getChocoMax(a));
		int[] b = {1};
		System.out.println(getChocoMax(b));
		int[] c = {1, 2, 3};
		System.out.println(getChocoMax(c));
	}
}
