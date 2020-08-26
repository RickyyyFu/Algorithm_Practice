package HexToDecimalValid;

import java.util.*;

public class HexToDecimalValid {
	public static String isValid() {
		try (Scanner scanner = new Scanner(System.in)) {
			String hex_str = scanner.nextLine().toUpperCase();
			
			if(hex_str.length() != 8) {
				System.out.println("INVALID");
				return "INVALID";
			}
			
			for(char c : hex_str.toCharArray()) {
				if(Character.isDigit(c)) continue;
				if(c >= 'A' && c <= 'F') continue;
				System.out.println("INVALID");
				return "INVALID";
			}
			String first_two = hex_str.substring(0, 2);
			String last_six = hex_str.substring(2);
			int decimal = Integer.parseInt(last_six, 16);
			int sum = 0;
			while(decimal > 0) {
				sum += (decimal % 10);
				decimal /= 10;
			}
			if(sum == Integer.parseInt(first_two, 16)) {
				System.out.println("VALID");
				return "VALID";
			}
			System.out.println("INVALID");
			return "INVALID";
		}
	}
	
	public static void main(String[] args) {
		isValid();
	}
}
