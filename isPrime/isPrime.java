package isPrime;

import java.util.Scanner;

public class isPrime {
    public static String countPrimes() {
    	Scanner scanner = new Scanner(System.in);
    	int n = Integer.parseInt(scanner.nextLine());
    	if(n == 0) {
    		scanner.close();
    		return "";
    	}

    	String[] str = scanner.nextLine().split(" ");
    	StringBuilder sb = new StringBuilder();
    	for(String s : str) {
    		int num = Integer.parseInt(s);
    		if(isprime(num)) sb.append("Prime");
    		else sb.append("Composite");
    		sb.append(" ");
    	}
        scanner.close();
        return sb.toString().trim();
    } 
    
    public static boolean isprime(int n) {
    	if(n <= 1) return false;
    	for(int i = 2; i*i < n; i++) {
    		if(n % i == 0) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	System.out.println(countPrimes());
    }
}
