package K_Occurence;

public class K_Occurence {
	public static int[] koccurence(String s, String[] words) {
		int[] res = new int[words.length];
		for(int i = 0; i < words.length; i++) {
			res[i] = getK(s, words[i]);
			System.out.print(res[i] + " ");
		}
		System.out.println();
		return res;
	}
	
	public static int getK(String s, String word) {
		int maxK = 0;
		
		int k = 0;
		int i = 0;
		int j = 0;
		while(i < s.length() && j < word.length()) {
			if(s.charAt(i) == word.charAt(j)) {
				i++;
				j++;
				
				// get one-k
				if(j == word.length()) {
					k++;
					maxK = Math.max(maxK, k);
					j = 0;
				}
			}
			else {
				k = 0;
				i = i - j + 1;
				j = 0;
			}
		}
		return maxK;
	}
	
	public static void main(String[] args) {
		String[] words = {"ab", "babc", "bca"};
		System.out.println(koccurence("ababcbabc", words));
	}
}
