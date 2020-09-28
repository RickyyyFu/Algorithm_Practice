package FindPairSumWithBoundedRange;

import java.util.Arrays;

public class FindPairSumWithBoundedRange {
	public static int findPair(int[] A, int[] B, int lower, int upper) {
		if(A.length > B.length) Arrays.sort(B);   // O(nlogn)
		else Arrays.sort(A);
	}
}
