package PaintHouse;

public class TrickyMethod {
	  public static int minCost(int[][] costs) {
	        int n = costs.length;
	        if(n==0)
	            return 0;
	        for(int i=1;i<n;i++){
	            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
	            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
	            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
	        }
	        return Math.min(Math.min(costs[n-1][0],costs[n-1][1]),costs[n-1][2]);
	    }
	  
	  public static void main(String[] args) {
		  int[][] costs = {
				  {1,2,2},
				  {2,2,1},
				  {2,1,2}
		  };
		  System.out.println(minCost(costs));
		  
		  int[][] costs1 = {
				  {1,2,3},
				  {1,2,3},
				  {1,3,2}
		  };
		  System.out.println(minCost(costs1));
	  }

}
