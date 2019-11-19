package reverse_string;

public class Solution {
	public String reverseString(String str){
		char[] c = str.toCharArray();
			int left = 0;
			int right = c.length - 1;
			while(left < right){
				char temp = c[left];
				c[left] = c[right];
				c[right] = temp;
				left++;
				right--;
			}
		return new String(c);
	}
}
