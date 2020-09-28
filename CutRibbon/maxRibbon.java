package CutRibbon;

public class maxRibbon {
	 public static int maxRibbon(int[] A, int k) {
	        int hi = 0;
	        for(int i = 0; i < A.length; i++) {
	            hi += A[i];
	        }
	        int lo = 0;
	        int res = 0;
	        while(lo <= hi) {
	            int mid = (lo + hi) / 2;
	            int part = 0;
	            for(int i = 0; i < A.length; i++) {
	                part += A[i]/mid;
	            }
	            if(part >= k) {
	                res = Math.max(res, mid);
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	        return res;
	    }

}
