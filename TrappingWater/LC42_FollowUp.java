package TrappingWater;
/**
 * 	中间是有0的，表示水可以漏出去
 */

// leftMax_arr[]	rightMax_arr[]
//	O(N)	have no overlap O(n*(N/n))
public class LC42_FollowUp {
	public static int trap(int[] height) {
		int n = height.length;
		if(n == 0) return 0;
		
		int[] ans = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = height[0];
		right[n-1] = height[n-1];
		for(int i = 1; i < n; i++) left[i] = Math.max(left[i-1], height[i]);
		for(int i = n-2; i >= 0; i--) right[i] = Math.max(right[i+1], height[i]);
		for(int i = 0; i < n; i++) ans[i] = Math.min(left[i], right[i]) - height[i];
		
		for(int i = 0; i < n; i++) {
			if(height[i] == 0) {
				int idx = i;
				while(idx >= 0 && ans[idx] != 0) {
					ans[idx] = 0;
					idx--;
				}
				idx = i+1;
				while(idx < n && ans[idx] != 0) {
					ans[idx] = 0;
					idx++;
				}
				i = idx;
			}
		}
		int res = 0;
		for(int i = 0; i < n; i++) res += ans[i];
		return res;
	}
	
	public static void main(String[] args) {
		int[] h1 = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(h1)); // 1
		
		int[] h2 = {0,1,0,2,1,1,1,3,2,1,2,1};
		System.out.println(trap(h2)); // 4
		
		int[] h3 = {0,0,0,2,1,0,1};
		System.out.println(trap(h3)); // 0
	}
}
