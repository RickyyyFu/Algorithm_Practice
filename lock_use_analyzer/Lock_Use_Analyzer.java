package lock_use_analyzer;

import java.util.*;

public class Lock_Use_Analyzer {
	public static int checkLockSequence(String[] sequences) {
		if(sequences == null || sequences.length == 0) return 0;
		
		Set<String> set = new HashSet<>();
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < sequences.length; i++) {
			String[] cmd = sequences[i].split(" ");
			String operate = cmd[0];
			String lock = cmd[1];
			
			if(operate.equals("ACQUIRE")) {
				if(set.contains(lock)) {
					return i + 1;
				}
				set.add(lock);
				stack.push(lock);
			}
			else {
				if(!stack.isEmpty() && stack.peek().equals(lock)) {
					set.remove(lock);
					stack.pop();
				}
				else {
					return i + 1;
				}
			}
		}
		if(stack.isEmpty()) {
			return 0;
		}
		else {
			return sequences.length + 1;
		}
	}
}
