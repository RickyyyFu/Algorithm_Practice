package Favorite_Genres;

import java.util.*;

public class Favorite_Genres {
	public static Map<String, List<String>> solution(Map<String, List<String>> userMap, Map<String, List<String>> genreMap){
		Map<String, List<String>> res = new HashMap<>();
		Map<String, String> song_genres = new HashMap<>();
		
//		if(genreMap.size() == 0 || genreMap == null)
		
		for(String genre : genreMap.keySet()) {
			List<String> genre_song = genreMap.get(genre);
			if(genre_song.size() == 0 || genre_song == null) continue;
			for(String song : genre_song) {
				song_genres.put(song, genre);
			}
		}
		
		// song have genre
		// input里有个genre to song的map，genre里没有song的话对应value会是null或者empty list？我建song to genre的时候check了一下
		for(String user : userMap.keySet()) {
			res.put(user, new ArrayList<String>());
			int maxCount = 0;
			
			List<String> songs = userMap.get(user);
			Map<String, Integer> genre_freq = new HashMap<>(); 
			for(String song : songs) {
				if(!song_genres.containsKey(song)) continue;
				String genre = song_genres.get(song);
				genre_freq.put(genre, genre_freq.getOrDefault(genre, 0) + 1);
				maxCount = Math.max(maxCount, genre_freq.get(genre));
			}
			
			for(String genre : genre_freq.keySet()) {
				if(maxCount == genre_freq.get(genre)) {
					res.get(user).add(genre);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Map<String, List<String>> userMap1 = new HashMap<>();
		userMap1.put("David", new ArrayList<String>(Arrays.asList("song1", "song2", "song3", "song4", "song8")));
		userMap1.put("Emma", new ArrayList<String>(Arrays.asList("song5", "song6", "song7")));
		
		Map<String, List<String>> genreMap1 = new HashMap<>();
		genreMap1.put("Rock", new ArrayList<String>(Arrays.asList("song1", "song3")));
		genreMap1.put("Dubstep", new ArrayList<String>(Arrays.asList("song7")));
		genreMap1.put("Techno", new ArrayList<String>(Arrays.asList("song2", "song4")));
		genreMap1.put("Pop", new ArrayList<String>(Arrays.asList("song5", "song6")));
		genreMap1.put("Jazz", new ArrayList<String>(Arrays.asList("song8", "song9")));
		
		Map<String, List<String>> res1 = solution(userMap1, genreMap1);
		for(String user : res1.keySet()) {
			System.out.println(user + ": " + res1.get(user).toString());
		}
		
		Map<String, List<String>> userMap2 = new HashMap<>();
		userMap2.put("David", new ArrayList<String>(Arrays.asList("song1", "song2")));
		userMap2.put("Emma", new ArrayList<String>(Arrays.asList("song3", "song4")));

		Map<String, List<String>> genreMap2 = new HashMap<>();
		
		Map<String, List<String>> res2 = solution(userMap2, genreMap2);
		System.out.println(res2.size());
		for(String user : res2.keySet()) {
			System.out.println(user + ": " + res2.get(user).toString());
		}
		
	}
}
