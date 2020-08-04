package UsernameSystem;

import java.util.*;

public class UserNameSystem {
	public static List<String> usernamesSystem(List<String> names){
		List<String> res = new ArrayList<>();
		
		Map<String, Integer> map = new HashMap<>();
		for(String name : names) {
			if(!map.containsKey(name)) map.put(name, 0);
			else {
				map.put(name, map.get(name)+1);
				name = name + map.get(name);
			}
			res.add(name);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String[] s = {"bob", "alice", "bob", "alice", "bob"};
		List<String> names = Arrays.asList(s);
		System.out.print(usernamesSystem(names));
	}
}
