package TwoSigma;

import java.util.*;

// constraint x, y
// when
public class Connect6 {
	int[][] grid;
	boolean T;
	int n;
	int round;
	
	Random r = new Random();
	
	public Connect6(int k) {
		reset(k);
	}
	
	public void reset(int k) {
		this.grid = new int[k][k];
		// or set 0s
		this.T = true;
		this.n = k;
		this.round = 0;
	}
	
	public String getTurn() {
		if(T) return "black";
		else return "white";
	} 
	
	public boolean placeBlack(int x, int y) {
		// if put the piece at position already allocated, skip it and return false 
		if(grid[x][y] == 0) {
			grid[x][y] = 1;
			round++;
			if(checkRow(x, y, 1) || checkCol(x, y, 1) || checkDiagonal(x, y, 1) || checkSubDiagonal(x, y, 1)) return true;
		}
		return false;
	}
	
	public boolean placeWhite(int x, int y) {
		// if put the piece at position already allocated, skip it and return false 
		if(grid[x][y] == 0) {
			grid[x][y] = 2;
			round++;
			if(checkRow(x, y, 2) || checkCol(x, y, 2) || checkDiagonal(x, y, 2) || checkSubDiagonal(x, y, 2)) return true;
		}
		return false;
	}
	
	// O(11)
	public boolean checkRow(int x, int y, int mark) {
		int cnt = 0;
		for(int i = y; i < y+6 && i < n; i++) {
			if(grid[x][i] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		for(int i = y-1; i > y-6 && i >= 0; i--) {
			if(grid[x][i] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		return false;
	}
	
	// O(11)
	public boolean checkCol(int x, int y, int mark) {
		int cnt = 0;
		for(int i = x; i < x+6 && i < n; i++) {
			if(grid[i][y] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		for(int i = x-1; i > x-6 && i >= 0; i--) {
			if(grid[i][y] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		return false;
	}
	
	// O(11)
	public boolean checkDiagonal(int x, int y, int mark) {
		int cnt = 0;
		for(int i = 0; i < 6 && i+x < n && i+y < n; i++) {
			if(grid[i+x][i+y] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		for(int i = -1; i > -6 && i+x >= 0 && i+y >=0; i--) {
			if(grid[i+x][i+y] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		return false;
	}
	
	// O(11)
	public boolean checkSubDiagonal(int x, int y, int mark) {
		int cnt = 0;
		for(int i = 0; i < 6 && x+i < n && y-i >= 0; i++) {
			if(grid[x+i][y-i] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		for(int i = -1; i > -6 && x+i >= 0 && y-i < n; i--) {
			if(grid[x+i][y-i] == mark) {
				cnt++;
				if(cnt == 6) return true;
			}
			else break;
		}
		return false;
	}
	
	public void play() {
		while(true) {
			if(round == 0) {
				// placeblack;
				// T = !T
				int x = r.nextInt(n-1);
				int y = r.nextInt(n-1);
				if(placeBlack(x, y)) {
					System.out.println("black win");
					return;
				}
				T = !T;
			}
			else {
			// constraint end?  full or win?
			// if without win? if put pieces at same pos always
				// black
				if(T) {
					System.out.println("put black");
					for(int k = 0; k < 2; k++) {
						int x = r.nextInt(n-1);
						int y = r.nextInt(n-1);
						if(placeBlack(x, y)) {
							System.out.println("black win");
							return;
						}
					}
					T = !T;
				}
				// white
				else {
					System.out.println("put white");
					for(int k = 0; k < 2; k++) {
						int x = r.nextInt(n-1);
						int y = r.nextInt(n-1);
						if(placeWhite(x, y)) {
							System.out.println("white win");
							return;
						}
					}
					T = !T;
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		Random r = new Random();
		Connect6 game = new Connect6(100);
		game.play();
	}
}
