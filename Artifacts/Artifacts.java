package Artifacts;

public class Artifacts {
	public static int[] searchArtifacts(int N, String artifacts, String searched) {
		int[] result = new int[2];
		int[][] graph = new int[N][N]; // index: 0 to N-1
		
		// deal with searched
		String[] search_pos = searched.split(" ");
		for(String pos : search_pos) {
			if(pos == null || pos.length() == 0) continue;
			
			int row = Integer.parseInt(pos.substring(0, pos.length()-1)) - 1; // the range of graph: 0 ~ N-1
			int col = pos.charAt(pos.length()-1) - 'A';
			graph[row][col] = 1; // mask as searched
		}
		
		// deal with artifacts
		String[] items = artifacts.split(",");
		for(String item : items) {
			if(item == null || item.length() == 0) continue;
			
			String[] position = item.split(" ");
			if(position == null || position.length == 0) continue;
			String left_top = position[0];
			String right_down = position[1];
			int row_start = Integer.parseInt(left_top.substring(0, left_top.length()-1)) - 1; // the range of graph: 0 ~ N-1
			int col_start = left_top.charAt(left_top.length()-1) - 'A';
			int row_end = Integer.parseInt(right_down.substring(0, right_down.length()-1)) - 1; // the range of graph: 0 ~ N-1
			int col_end = right_down.charAt(right_down.length()-1) - 'A';
			
			// identify if the position of item's pieces is searched 
			boolean searched_pos = false;
			boolean not_searched_pos = false;
			for(int i = row_start; i <= row_end; i++) {
				for(int j = col_start; j <= col_end; j++) {
					if(graph[i][j] == 1) searched_pos = true;
					else not_searched_pos = true;
				}
			}
			if(searched_pos == true && not_searched_pos == false) result[0]++;
			if(searched_pos == true && not_searched_pos == true) result[1]++;
		}		
		
		System.out.println(result[0] + " " + result[1]);
		return result;
	}
	
	public static void main(String[] args) {
		searchArtifacts(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
		searchArtifacts(3, "1A 1B,2C 2C", "1B");
		searchArtifacts(4, "", "");
		searchArtifacts(1, " ", " ");
		searchArtifacts(1, "", " ");
	}
}
