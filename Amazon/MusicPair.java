package Amazon;

public class MusicPair {
	public int numPairsDivisibleBy60(int[] time) {
		int c[] = new int[60];
		int res = 0;
		
		for(int t : time) {
			res += c[(540-t) % 60];
			c[t % 60] += 1;
		}
		
		return res;
	}
}
