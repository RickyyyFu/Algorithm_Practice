package SquareNumber;

public class SquareNumber {
	public static int countSquare(int a, int b) {
		int count = 0;
		
		int base = (int) Math.sqrt(a);
		while(base * base <= b) {
			if(base * base >= a) count++;
			base++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countSquare(4, 10));
		System.out.println(countSquare(3, 9));
		System.out.println(countSquare(17, 24));
	}
}
