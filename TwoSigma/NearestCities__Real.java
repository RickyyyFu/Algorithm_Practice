package TwoSigma;

import java.util.*;

public class NearestCities__Real {
	public static List<String> solution(List<String> c, List<Integer> x, List<Integer> y, List<String> q){
		List<String> res = new ArrayList<>();
		for(int i = 0; i < q.size(); i++) {
			res.add("NONE");
		}
		
		Map<String, String> p_name = new HashMap<>();
		Map<String, int[]> name_p = new HashMap<>();
		Map<Integer, TreeSet<Integer>> mx = new HashMap<>();
		Map<Integer, TreeSet<Integer>> my = new HashMap<>();
		
		int[][] points = new int[x.size()][2];
		for(int i = 0; i < x.size(); i++) {
			int xx = x.get(i);
			int yy = y.get(i);
			points[i][0] = xx;
			points[i][1] = yy;
			String pos = xx + "-" + yy;
			p_name.put(pos, c.get(i));
			name_p.put(c.get(i), points[i]);
			
			if(!mx.containsKey(xx)) mx.put(xx, new TreeSet<>());
			mx.get(xx).add(yy);
			if(!my.containsKey(yy)) my.put(yy, new TreeSet<>());
			my.get(yy).add(xx);
		}
		
		// System.out.println(p_name);
		
		for(int i = 0; i < q.size(); i++) {
			int min = Integer.MAX_VALUE;
			String ans = res.get(i);
			
			// corner case
			if(!name_p.containsKey(q.get(i))) continue;
			int[] pos = name_p.get(q.get(i));
			// x
			if(mx.containsKey(pos[0])) {
				Integer higher = mx.get(pos[0]).higher(pos[1]);
				Integer lower = mx.get(pos[0]).lower(pos[1]);
				
				if(higher != null && higher-pos[1] <= min) {
					String s = pos[0] + "-" + higher;
					String str = p_name.get(s);
					System.out.println(str);
					if(higher-pos[1] == min) {
						if(ans.equals("NONE") || str.compareTo(ans) < 0) res.set(i, str);
					}
					if(higher-pos[1] < min) {
						min = higher-pos[1];
						res.set(i, str);
					}
				}
				
				if(lower != null && pos[1]-lower <= min) {
					String s = pos[0] + "-" + lower;
					String str = p_name.get(s);
					System.out.println(str);
					if(pos[1]-lower == min) {
						if(ans.equals("NONE") || str.compareTo(ans) < 0) res.set(i, str);
					}
					if(pos[1]-lower < min) {
						min = pos[1]-lower;
						res.set(i, str);
					}
				}
			}
			
			// y
			if(my.containsKey(pos[1])) {
				Integer higher = my.get(pos[1]).higher(pos[0]);
				Integer lower = my.get(pos[1]).lower(pos[0]);
				
				if(higher != null && higher-pos[0] <= min) {
					String s =  higher + "-" + pos[1];
					String str = p_name.get(s);
					System.out.println(str);
					if(higher-pos[0] == min) {
						if(ans.equals("NONE") || str.compareTo(ans) < 0) res.set(i, str);
					}
					if(higher-pos[0] < min) {
						min = higher-pos[0];
						res.set(i, str);
					}
				}
				
				if(lower != null && pos[0]-lower <= min) {
					String s =  lower + "-" + pos[1];
					String str = p_name.get(s);
					System.out.println(str);
					if(pos[0]-lower == min) {
						if(ans.equals("NONE") || str.compareTo(ans) < 0) res.set(i, str);
					}
					if(pos[0]-lower < min) {
						min = pos[0]-lower;
						res.set(i, str);
					}
				}
			}
 		}
		
		return res;
	}
	
	public static void main(String[] args) {
		List<String> cc1 = new ArrayList<>();
		cc1.add("c1"); cc1.add("c2"); cc1.add("c3");
		List<Integer> x1 = new ArrayList<>();
		x1.add(1); x1.add(2); x1.add(3);
		List<Integer> y1 = new ArrayList<>();
		y1.add(3); y1.add(2); y1.add(3);
		List<String> q1 = new ArrayList<>();
		q1.add("c1"); q1.add("c2"); q1.add("c3");
		System.out.println(solution(cc1, x1, y1, q1));
		
		List<String> cc2 = new ArrayList<>();
		cc2.add("fastcity"); cc2.add("bigbanana"); cc2.add("xyz");
		List<Integer> x2 = new ArrayList<>();
		x2.add(23); x2.add(23); x2.add(23);
		List<Integer> y2 = new ArrayList<>();
		y2.add(1); y2.add(10); y2.add(20);
		List<String> q2 = new ArrayList<>();
		q2.add("fastcity"); q2.add("bigbanana"); q2.add("xyz"); q2.add("1");
		System.out.println(solution(cc2, x2, y2, q2));
	}
}
