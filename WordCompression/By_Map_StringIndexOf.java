package WordCompression;

import java.util.*;

public class By_Map_StringIndexOf {
	public static String compressWord(String word, int k) {
		if(word.length() < 3) return word;
		
		Map<Character, String> map = new HashMap<>();
		for(char c : word.toCharArray()) {
			if(!map.containsKey(c)) {
				
			}
		}
	}
}
