package DeleteCharInterval;

import java.util.*;

/**
 *	 给一个string, 给一些interval，然后返回一个string并去除interval范围内的字符
 *
 */
public class DeleteCharInterval {
	public static String deleteChar(String s, int[][] intervals) {
		if(s == null || s.length() == 0 || intervals == null || intervals.length == 0) return s;
		
		// merge intervals
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]==b[0]) ? a[0]-b[0] : a[1]-b[1]);
		for(int[] interval : intervals) pq.offer(interval);
		
		int[] cur = pq.poll();
		int start = cur[0];
		int end = cur[1];
		List<int[]> list = new ArrayList<>();
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(cur[0] <= end) {
				end = cur[1];
			}
			else {
				list.add(new int[] {start, end});
				start = cur[0];
				end = cur[1];
			}
		}
		list.add(new int[] {start, end});
		
		int start_idx = 0;
		StringBuilder sb = new StringBuilder();
		for(int[] interval : list) {
			if(interval[0] >= s.length()) break;
			sb.append(s.substring(start_idx, interval[0]));
			start_idx = interval[1]+1;
		}
		if(start_idx < s.length()) sb.append(s.substring(start_idx));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[][] i1 = {{1,2}, {3,6}, {4,7}};
		System.out.println(deleteChar("abcdefghi", i1)); //ai
		
		int[][] i2 = {{1,2}, {3,6}, {4,7}};
		System.out.println(deleteChar("aaaaaaaaaa", i2)); //aaa
		
		int[][] i3 = {{1,2}, {3,6}, {4,7}};
		System.out.println(deleteChar("a", i3)); // a
		
		int[][] i4 = {{0,3}, {3,6}, {4,7}};
		System.out.println(deleteChar("a", i4));
		System.out.println(deleteChar("aaaaaaaai", i4)); // i
	}
}
