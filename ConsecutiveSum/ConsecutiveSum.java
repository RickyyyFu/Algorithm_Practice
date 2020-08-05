/**
 * LC 829
 * N = k + (k+1) + (k+2) + (k+3) + ... + (k+i-1) = i*k + (1+2+3+... + i-1)
 * sum(i) = (1+2+3+...+i-1), then we have N = sum(i) + i*k ==> i*k = N - sum(i)
 * 
 * for each i, we can calculate N-sum(i). If N-sum(i) can be divided by i, there is an answer with length i.
 * Because, let k = (N - sum(i)) / i, we can add an integer k to each of (0,1, 2, 3, 4, ...., i) to become (k, k+1, k+2, k+3,.... k + i)
 * that is: sum(i) + i * k = N
 * 
 * 
 */

package ConsecutiveSum;

public class ConsecutiveSum {
	public static int consecutiveNumbersSum(int N) {
	    int ans = 0;
		int sum = 0;
	    for(int i = 1; sum < N; i++) {
	        if ((N-sum) % i == 0) ans++;
	        sum += i;
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(consecutiveNumbersSum(21));
		System.out.println(consecutiveNumbersSum(5));
		System.out.println(consecutiveNumbersSum(15));
		System.out.println(consecutiveNumbersSum(9));
	}
}