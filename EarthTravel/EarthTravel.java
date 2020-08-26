package EarthTravel;

import java.util.*;

public class EarthTravel {
	static Map<String, double[]> city_pos = new HashMap<>();
	static int radius = 3963;
	
	public static String parseInput(String input) {
		String[] info = input.split(":");
		if(info[0].equals("LOC")) {
			String city = info[1];
			double latitude = Double.valueOf(info[2]);
			double longitude = Double.valueOf(info[3]);
			city_pos.put(city, new double[] {latitude, longitude});
			
			System.out.println(city);
			return city;
		}
		else if(info[0].equals("TRIP")) {
			String user = info[1];
			double[] pos1 = city_pos.get(info[2]);
			double[] pos2 = city_pos.get(info[3]);
			double lati1 = pos1[0] * Math.PI / 180;
			double longi1 = pos1[1] * Math.PI / 180;
			double lati2 = pos2[0] * Math.PI / 180;
			double longi2 = pos2[1] * Math.PI / 180;
			
			double longi_diff = Math.abs(longi1 - longi2);
			double angle = Math.acos(Math.sin(lati1)*Math.sin(lati2) + Math.cos(lati1)*Math.cos(lati2)*Math.cos(longi_diff));
			int dis = (int)(radius * angle);

			String res = user + ":" + info[2] + ":" + info[3] + ":" + dis;
			System.out.println(res);
			return String.valueOf(res);
		}
		return "";
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