package gamble;

public class Gamble {
	public static int solution(int N, int K) {
		// greedy algorithm
		// use all-in when having as many chips as possible
		if(K == 0) return N - 1;
		
		int round = 0;
		while(N > 1) { // start with 1 chip
			round++;
			
			// if N is even (can be gotten by 2N) and K > 0, use all-in
			if(N % 2 == 0 && K > 0) {
				N /= 2;
				K--;
			}
			else {
				N--;
			}
		}
		return round;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(8, 0));
		System.out.println(solution(18, 2));
		System.out.println(solution(10, 10));
	}
}
