package EmailThread;

import java.util.*;

public class EmailThread {
	static class Pair{
		int tid;
		String[] contents;
		
		public Pair(int tid, String[] contents) {
			this.tid = tid;
			this.contents = contents;
		}
	}
	
	public static List<List<Integer>> email_thread(String[] emails) {
		List<List<Integer>> res = new ArrayList<>();
		Map<String, Pair> map = new HashMap<>();
		int tid = 0;
		
		for(String email : emails) {
			String[] s = email.split(",");
			String sender = s[0];
			String receiver = s[1];
			String content = s[2];
			String[] contents = content.split("---");
			
			if(sender.compareTo(receiver) > 0) {
				String temp = sender;
				sender = receiver;
				receiver = temp;
			}
			String mark = sender + receiver;
			
			if(!map.containsKey(mark)) {
				tid++;
				map.put(mark, new Pair(tid, contents));
				List<Integer> list = new ArrayList<>();
				list.add(tid);
				list.add(contents.length);
				res.add(list);
			}
			else {
				Pair pair = map.get(mark);
				String[] old = Arrays.asList(contents).subList(1,contents.length).toArray(new String[0]);
				
				boolean existed = false;
				if(Arrays.equals(pair.contents, old)) {
					existed = true;
					pair.contents = contents;
					List<Integer> list = new ArrayList<>();
					list.add(pair.tid);
					list.add(pair.contents.length);
					res.add(list);
				}
				if(!existed) {
					tid++;
					pair.contents = contents;
					List<Integer> list = new ArrayList<>();
					list.add(tid);
					list.add(pair.contents.length);
					res.add(list);
				}
			}
			
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		String s = "1,2,3,4";
		String[] s1 = { "a@gmail.com,b@gmail.com,abc",
			    "c@gmail.com,d@gmail.com,hhh",
			    "b@gmail.com,a@gmail.com,cde---abc"};
		String[] s2 = {"a@gmail.com,b@gmail.com,abc","a@gmail.com,b@gmail.com,abc","b@gmail.com,a@gmail.com,cde---abc","b@gmail.com,a@gmail.com,def---cde---abc"};
		System.out.println(email_thread(s1));
		System.out.println(email_thread(s2));
	}
}
