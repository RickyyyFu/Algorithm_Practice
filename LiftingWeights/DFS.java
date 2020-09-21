package LiftingWeights;

public class DFS {
	public static void dfs(int[] weights, int start, int curWeight, int maxCapacity) {
		if(curWeight > maxCapacity) return;
		
		max = Math.max(max, curWeight);
		for(int i = start; i < weights.length; i++) {
			curWeight += weights[i];
			dfs(weights, i+1, curWeight, maxCapacity);
			curWeight -= weights[i];
		}
	}
	
	static int max = 0;
	public static int maxWeight(int[] weights, int maxCapacity) {
		dfs(weights, 0, 0, maxCapacity);
		return max;
	}
	
	public static void main(String[] args) {
		int[] w1 = {1,3,5};
		int[] w2 = {4,8,5,9};
		System.out.println(maxWeight(w1, 7));
		System.out.println(maxWeight(w2, 20));
	}
}
