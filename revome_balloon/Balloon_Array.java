package revome_balloon;

public class Balloon_Array {
	public static int solution(String s) {
		int res = Integer.MAX_VALUE;
		int[] bucket = new int[26];
		
		for(char c : s.toCharArray()) {
			bucket[c - 'A']++;
		}
		
		res = Math.min(res, bucket['B' - 'A']);
		res = Math.min(res, bucket['A' - 'A']);
		res = Math.min(res, bucket['L' - 'A'] / 2);
		res = Math.min(res, bucket['O' - 'A'] / 2);
		res = Math.min(res, bucket['N' - 'A']);
		
		return res;
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100000000; i++) {
			sb.append("B");
		}
		float start = System.currentTimeMillis();
	    int res1 = solution(sb.toString());
	    float end = System.currentTimeMillis();
	    System.out.println(res1);
	    System.out.println("Total the time taken process :" + (end - start) + " milisec.");
	}
}
