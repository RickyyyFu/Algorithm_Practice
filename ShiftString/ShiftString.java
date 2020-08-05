package ShiftString;

public class ShiftString {
	public static String getShiftedString(String s, int leftShifts, int rightShifts) {
		int shiftLeft = (leftShifts - rightShifts) % s.length();
		if(shiftLeft < 0) shiftLeft += s.length();
		return s.substring(shiftLeft) + s.substring(0, shiftLeft);
	}
	
	public static void main(String[] args) {
		System.out.println(getShiftedString("abcde", 3, 1));
		System.out.println(getShiftedString("abcde", 0, 2));
		System.out.println(getShiftedString("abcde", 2, 2));
	}
}
