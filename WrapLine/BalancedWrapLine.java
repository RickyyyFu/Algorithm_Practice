/**
 * We are building a word processor and we would like to implement a "reflow" functionality that also applies full justification to the text.
Given an array containing lines of text and a new maximum width, re-flow the text to fit the new width. Each line should have the exact specified width. If any line is too short, insert '-' (as stand-ins for spaces) between words as equally as possible until it fits.

Note: we are using '-' instead of spaces between words to make testing and visual verification of the results easier.
 */

package WrapLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Ricky
 *	Time: O(n) at worst
 *	Space: O(n)
 */

public class BalancedWrapLine {
	public static List<String> balancedWrapLine(String[] lines, int maxLength){
		// unbalanced
		List<String> unbalanced = new ArrayList<>();
		List<String> words = new ArrayList<>();
		for(String line : lines) {
			String[] word_array = line.split(" ", -1);
			Collections.addAll(words, word_array);
		}
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while(idx < words.size()) {
			if(sb.length() == 0) sb.append(words.get(idx++));
			else if(sb.length() + 1 + words.get(idx).length() <= maxLength) {
				sb.append("-");
				sb.append(words.get(idx++));
			}
			else {
				unbalanced.add(sb.toString());
				sb.setLength(0);
			}
		}
		if(sb.length() != 0) unbalanced.add(sb.toString());
		
		
		// balanced
		List<String> balanced = new ArrayList<>();
		for(String line : unbalanced) {
			StringBuilder sb_line = new StringBuilder(line);
			int n = maxLength - sb_line.length(); // the number of "-" needed
			
			// there is no "-" in the line
			if(!sb_line.toString().contains("-")) {
				balanced.add(sb_line.toString());
				continue;
			}
			
			// add "-"
			// O(n^2)
			while(n > 0) {
				int i = 0;
				while(i < sb_line.length()-1) {
					if(sb_line.charAt(i) == '-' && sb_line.charAt(i+1) != '-') {
						sb_line.insert(i+1, "-");
						i++;
						n--;
						
						if(n == 0) break;
					}
					i++; // go to another letter(not "-")
				}
			}
			balanced.add(sb_line.toString());
		}
		return balanced;
	}
	
	public static void main(String[] args) {
		String[] line = {"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
		System.out.println(balancedWrapLine(line, 10));
		System.out.println(balancedWrapLine(line, 15));
		String[] line1 = {"The day began as still as the",
		          "night abruptly lighted with",
		          "brilliant flame" };
		System.out.println(balancedWrapLine(line1, 24));
	}
}
