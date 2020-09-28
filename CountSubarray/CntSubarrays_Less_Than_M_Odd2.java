// dp

package CountSubarray;

public class CntSubarrays_Less_Than_M_Odd2 {
	public static int countSubarrays3(int a[], int n, int m){ 
		if(a == null || a.length == 0) return 0;
		
		int l = 0, r = 0;
		int odd = 0;
		int res = 0;
		
		while(r < a.length) {
			if(a[r] % 2 == 1) odd++;
			int remain = a.length - r;
			
			if(odd > m) {
				while(l <= r && odd > m) {
					res += remain;
					
					if(a[l] % 2 == 1) odd--;
					l++;
				}
			}
			r++;
		}
		int sum = a.length * (a.length+1) / 2;
		return sum - res;
	} 
	
	// Driver code 
	public static void main (String[] args){ 
		int a[] = { 2, 2, 5, 6, 9, 2, 11 }; 
		// int a[] = {2, 5, 6, 9};
		int n = a.length; 
		int m = 1; 

		System.out.println(countSubarrays3(a, n, m)); 
	} 
}