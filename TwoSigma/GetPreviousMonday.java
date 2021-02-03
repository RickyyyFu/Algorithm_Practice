package TwoSigma;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class GetPreviousMonday {
	public static String getPreviousMonday(String s) {
		String str = s.substring(0, 4)+"-"+s.substring(4,6)+"-"+s.substring(6,8);
		LocalDate date = LocalDate.parse(str);
		LocalDate monday = date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
		
		return monday.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getPreviousMonday("20201212"));
		System.out.println(getPreviousMonday("20201207"));
	}
}
