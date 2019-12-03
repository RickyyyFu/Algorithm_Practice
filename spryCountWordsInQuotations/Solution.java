package spryCountWordsInQuotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
	static class Word_Frequence{
		String word;
		int frequence;
		
		public Word_Frequence(String word, int frequence){
			this.word = word;
			this.frequence = frequence;
		}
	}
	
	public static void spryCountWordsInQuotations(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));

        // count occurrences
        Map<String, Integer> wordCounts = new HashMap<String, Integer>();
        boolean withinQuation = false;
        
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if(isNumeric(next)) continue; // Ignore all the words containing numbers 
            
            // case: "..."
            if(!withinQuation && isQuotation(next.charAt(0)) && isQuotation(next.charAt(next.length() - 1))) {
            	String word = next.substring(1, next.length() - 1);
            	if (!wordCounts.containsKey(word)) {
                    wordCounts.put(word, 1);
                } else {
                    wordCounts.put(next, wordCounts.get(word) + 1);
                }
            	continue;
            }
            
            for(int i = 0; i < next.length(); i++) {
            	char c = next.charAt(i);
            	if(c == '\u0022' || c == '\u201C' || c == '\u201D') {
            		withinQuation = !withinQuation;
            		if(withinQuation) {
            			next = next.substring(1);
            		}
            		else {
            			next = next.substring(0, next.length() - 2);
            			if (!wordCounts.containsKey(next)) {
                            wordCounts.put(next, 1);
                        } else {
                            wordCounts.put(next, wordCounts.get(next) + 1);
                        }
            		}
            	}
            }
            
            if(withinQuation) {
    			if(!Character.isLetter(next.charAt(next.length() - 1))) {
    				next = next.substring(0, next.length() - 1);
    			}
            	if (!wordCounts.containsKey(next)) {
                    wordCounts.put(next, 1);
                } else {
                    wordCounts.put(next, wordCounts.get(next) + 1);
                }
            }
        }
        
        PriorityQueue<Word_Frequence> pq= new PriorityQueue<Word_Frequence>((a,b) -> (b.frequence - a.frequence));
        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            Word_Frequence obj = new Word_Frequence(word, count);
            pq.add(obj);
        }
        
        while(!pq.isEmpty()) {
        	Word_Frequence obj = pq.poll();
        	System.out.println(obj.word + " -> " + obj.frequence);
        }
	}
	
	private static boolean isQuotation(char c) {
		if(c == '\u0022' || c == '\u201C' || c == '\u201D') {
			return true;
		}
		return false;
	}

	private static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		spryCountWordsInQuotations("/Users/curlyfu/eclipse-workspace-info6205/Practice/src/spryCountWordsInQuotations/text1");
	}
}
