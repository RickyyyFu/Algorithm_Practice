package CountSubarray;

public class CntSubarray_M_odd1 {
	public static int countSubarrays1(int a[], int n, int m){ 
		int count = 0; 

		// traverse for all possible subarrays 
		for (int i = 0; i < n; i++){ 
			int odd = 0; 

			for (int j = i; j < n; j++){ 
				if (a[j] % 2 == 1) odd++; 

				// if count of odd numbers in subarray is m 
				if (odd == m) count++; 
			} 
		} 

		return count; 
	} 

	// Driver code 
	public static void main (String[] args){ 
		int a[] = { 2, 2, 5, 6, 9, 2, 11 }; 
		// int a[] = {2, 5, 6, 9};
		int n = a.length; 
		int m = 3; 

		System.out.println(countSubarrays1(a, n, m)); 
	} 
}
