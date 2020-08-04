package MysteryAlg;

public class MystreyAlg {
	public static int mystreyAlg(int a, int b) {
		int x = a;
		int y = b;
		while(x != y) {
			if(x > y) x -= y;
			if(x < y) y -= x;
		}
		return x;
	}
	
	public static void main(String[] args) {
		System.out.print(mystreyAlg(2437, 875));
	}

}
