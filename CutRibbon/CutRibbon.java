package CutRibbon;

// 给定array of of ribbons 和一个target k。要求找到最长的长度L 使得你可以cut all the ribbons so that you have at lease k ribbons with length L.
// 用了二分法，但还是有两个case没有过

public class CutRibbon {
	public static int greatestLength(int[] arr, int k) {
		   if (k <= 0) return 0;
		   int max = 0;
		   for (int a : arr) {
		     max = Math.max(max, a);
		   }
		   int lo = 1, hi = max;
		   while (lo <= hi) {
		     int mid = lo + (hi - lo) / 2;
		     int len = getLen(arr, mid);
		     if (len >= k) { lo = mid + 1; }
		     else { hi = mid - 1; }
		   }
		   return hi;
		 }
		 private static int getLen(int[] arr, int target) {
		   int res = 0;
		   for (int a : arr) {
		     res += (a / target);
		   }
		   return res;
		 }

		 public static void main(String[] args){
		   int[] arr = {1, 2, 3, 4, 9};
		   System.out.println(greatestLength(arr, 5));
		 }

}
