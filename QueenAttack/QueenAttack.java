package QueenAttack;

import java.util.*;

public class QueenAttack {
	public static String queenattack() {
		Scanner scanner = new Scanner(System.in);
        String queen_pos = scanner.nextLine();
        // System.out.print(queen_pos);
        String opponent_pos = scanner.nextLine();
        
        String[] coordinate_queen = queen_pos.split(" ");
        String[] coordinate_opponent = opponent_pos.split(" ");
        int x_queen = Integer.parseInt(coordinate_queen[0]);
        int y_queen = Integer.parseInt(coordinate_queen[1]);
        int x_opponent = Integer.parseInt(coordinate_opponent[0]);
        int y_opponent = Integer.parseInt(coordinate_opponent[1]);
        
        String result = "No";
        if(x_queen == x_opponent || y_queen == y_opponent || x_queen+y_queen == x_opponent+y_opponent || x_queen-y_queen == x_opponent-y_opponent)
        	result = "Yes";
        scanner.close();
        System.out.println(result);
        
        return result;
	}
	
	public static void main(String[] args) {
		queenattack();
	}
}
