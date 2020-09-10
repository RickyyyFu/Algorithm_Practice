package StudentCourseOverlap;

import java.util.*;

public class StudentCourseOverlap {
	public static Map<String, List<String>> courseSchedule1(String[][] pairs){
		Map<String, Set<String>> student_course = new HashMap<>();
		for(String[] pair : pairs) {
			String student = pair[0];
			String course = pair[1];
			if(!student_course.containsKey(student)) student_course.put(student, new HashSet<>());
			student_course.get(student).add(course);
		}
		
		Map<String, List<String>> res = new HashMap<>();
		for(String s1 : student_course.keySet()) {
			Set<String> courses = student_course.get(s1);
			for(String s2 : student_course.keySet()) {
				if(s1.equals(s2)) continue;
				
				String key = "";
				if(s1.compareTo(s2) < 0) key = "[" + s1 + ", " + s2 + "]";
				else key = "[" + s2 + ", " + s1 + "]";
				if(!res.containsKey(key)) {
					res.put(key, new ArrayList<>());
					for(String course : student_course.get(s2)) {
						if(courses.contains(course)) res.get(key).add(course);
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {
				{"58", "Software Design"},
				{"58", "Linear Algebra"},
				{"94", "Art History"},
				{"94", "Operating Systems"},
				{"17", "Software Design"},
				{"58", "Mechanics"},
				{"58", "Economics"},
				{"17", "Linear Algebra"},
				{"17", "Political Science"},
				{"94", "Economics"},
				{"25", "Economics"}
		};
		Map<String, List<String>> res = courseSchedule1(pairs);
		System.out.println(res);
	}
}
