package EvenSubarray;

public class EvenSubarray {
	public static int evenSubarray(int[] numbers, int k) {
		int left = 0;
		int right = left;
		int subOddCount = 0;
		int res = 0;
		
		while(right < numbers.length) {
			int num = numbers[right];
			
			if(num % 2 == 1) subOddCount++;
			if(subOddCount > k){
				while(numbers[left] % 2 == 0) left++;
				left++;
				subOddCount--;
			}
			res += (right-left+1);
			right++;
		}
		return res;
	}

	public static void main (String[] args){ 
		//int a[] = {1, 2, 3, 4}; 
		int a[] = { 2, 2, 5, 6, 9, 2, 11 }; ;
		int m = 1; 

		System.out.println(evenSubarray(a, m)); 
	} 
}
