package Right_Up_Right_Down;

import java.util.Arrays;
import java.util.*;

public class SortFirstColumn {
	public int[] solution(int[][] matrix){
        TreeMap<Integer, PriorityQueue<Integer>> treemap = new TreeMap<>();
		
		int n = matrix.length;
        for(int i=1; i<n; i++){
            int row = i;
            int col = 0;
            int sum = 0;
            boolean flag = false;
            while(col<n){
                sum+=matrix[row][col];
                if(!flag) {
                    row--;
                    col++;
                }else{
                    row++;
                    col++;
                }
                if(row==0){
                    flag = true;
                }

            }
            if(!treemap.containsKey(sum)) treemap.put(sum, new PriorityQueue<Integer>());
            treemap.get(sum).offer(matrix[i][0]);
        }
        
        int[] res = new int[n-1];
        int i = 0;
        for(int key : treemap.keySet()) {
        	PriorityQueue<Integer> pq = treemap.get(key);
        	while(!pq.isEmpty()) {
        		res[i] = pq.poll();
        		i++;
        	}
        }
        return res;
    }


    public static void main(String[] args){
    	SortFirstColumn mb = new SortFirstColumn();
        int[][] matrix = new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
        int[] res = mb.solution(matrix);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }
}
