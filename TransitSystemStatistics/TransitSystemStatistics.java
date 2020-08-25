package TransitSystemStatistics;

import java.util.*;

public class TransitSystemStatistics {
	static Map<String, Integer> user_dis = new HashMap<>();
	static Map<String, Integer> city_time = new HashMap<>();
	static String city = "";
	static int most_time = 0;
	static String user = "";
	static int longest_dis = 0;
	static int total_dis = 0;
	
	public static String parseInput(String str) {
		String[] info = str.split(":");
		String id = info[0];
		String city1 = info[1];
		String city2 = info[2];
		int distance = Integer.valueOf(info[3]);
		
		total_dis += distance;
		
		user_dis.put(id, user_dis.getOrDefault(id, 0) + distance);
		if(user_dis.get(id) > longest_dis) {
			user = id;
			longest_dis = user_dis.get(id);
		}
		else if(user_dis.get(id) == longest_dis) {
			if(id.compareTo(user) < 0) user = id; 
		}
		
		city_time.put(city1, city_time.getOrDefault(city1, 0) + 1);
		if(city_time.get(city1) > most_time) {
			city = city1;
			most_time = city_time.get(city1);
		}
		else if(city_time.get(city1) == most_time) {
			if(city1.compareTo(city) < 0) city = city1; 
		}
		city_time.put(city2, city_time.getOrDefault(city2, 0) + 1);
		if(city_time.get(city2) > most_time) {
			city = city2;
			most_time = city_time.get(city2);
		}
		else if(city_time.get(city2) == most_time) {
			if(city2.compareTo(city) < 0) city = city2; 
		}
		
		String res = total_dis + ":" + user + ":" + city;
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			int N = Integer.valueOf(scanner.nextLine());
			for(int i = 0; i < N; i++) {
				String input = scanner.nextLine();
				parseInput(input);
			}
		}
	}
}
