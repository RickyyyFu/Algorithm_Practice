package SMS_Splitting;

import java.util.*;

public class Result {
	public static List<String> segments(String message) {
	    List<String> res = new ArrayList<>();
	    if (message.length() <= 160) {
	        res.add(message);
	        return res;
	    }
	    int len = message.length();
	    int num = 155;
	    int start = 0;
	    int end = num - 1;
	    while (end < len) {
	        char c = message.charAt(end);
	        if (c != ' ') {
	            if(end + 1 < len && message.charAt(end + 1) != ' '){
	                while (end >= start && c != ' ') {
	                    end--;
	                }
	            }
	        }
	        res.add(message.substring(start, end + 1));
	        start = end + 1;
	        end = start + num - 1;
	    }
	    res.add(message.substring(start, len));

	    for (int i = 0; i < res.size(); i++) {
	        res.set(i, res.get(i)+"(" + (i + 1) + "/" + (res.size()) + ")");
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		String message = "abcd efg";
		System.out.println(segments(message));
	}
}
