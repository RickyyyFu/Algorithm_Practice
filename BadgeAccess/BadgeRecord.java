/**
 * We are working on a security system for a badged-access room in our company's building. Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collection
	1.	All employees who didn't use their badge while exiting the room ¨C they recorded an enter without a matching exit
	2.	All employees who didn't use their badge while entering the room  ¨C they recorded an exit without a matching enter

 *	O(n)	O(n)
 */


package BadgeAccess;

import java.util.*;

public class BadgeRecord {
	public static List<Set<String>> recordBadge(String[][] records){
		Set<String> hasEntered = new HashSet<>();
		Set<String> invalidEnter = new HashSet<>();
		Set<String> invalidExit = new HashSet<>();
		for(String[] record : records) {
			String name = record[0];
			String action = record[1];
			if(action.equals("enter")) {
				if(hasEntered.contains(name)) invalidEnter.add(name);
				else hasEntered.add(name);
			}
			else if(action.equals("exit")) {
				if(!hasEntered.contains(name)) invalidExit.add(name);
				else hasEntered.remove(name);
			}
		}
		for(String name : hasEntered) {
			invalidEnter.add(name);
		}
		
		List<Set<String>> res = new ArrayList<>();
		res.add(invalidEnter);
		res.add(invalidExit);
		
		return res;
	}
	
	public static void main(String[] args) {
		String[][] records = {
				{"Martha",   "exit"},
				{"Paul",     "enter"},
				{"Martha",   "enter"},
				{"Martha",   "exit"},
				{"Jennifer", "enter"},
				{"Paul",     "enter"},
				{"Curtis",   "enter"},
				{"Paul",     "exit"},
				{"Martha",   "enter"},
				{"Martha",   "exit"},
				{"Jennifer", "exit"}
		};
		System.out.println(recordBadge(records));
	}
}
