package CountSubarray;

public class CntSubarrays_Less_Than_M_Odd {
	public static int countSubarrays2(int a[], int n, int m){ 
		int count = 0; 

		// traverse for all possible subarrays 
		for (int i = 0; i < n; i++){ 
			int odd = 0; 

			for (int j = i; j < n; j++){ 
				if (a[j] % 2 == 1) odd++; 

				// if count of odd numbers in subarray is m 
				if (odd <= m) {
					for(int s = i; s <= j; s++) System.out.print(a[s] + " ");
					count++; 
				}
				System.out.println();
			} 
		} 

		return count; 
	} 
	
	// Driver code 
	public static void main (String[] args){ 
		int a[] = { 2, 2, 5, 6, 9, 2, 11 }; 
		// int a[] = {2, 5, 6, 9};
		int n = a.length; 
		int m = 1; 

		System.out.println(countSubarrays2(a, n, m)); 
	} 
}
