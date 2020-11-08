package Amazon;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Ricky
 *	O(N)
 *	O(1)
 */

public class UtilizationChecks {
	private static final int LIMIT = 2 * 100_000_000;

	public static int solution(int instances, List<Integer> utilizationUtil) {
		int i = 0;
		while(i < utilizationUtil.size()) {
			if(utilizationUtil.get(i) < 25 && instances > 1) {
				if(instances % 2 == 1) instances++;
				instances /= 2;
				i += 10;
			}
			else if(utilizationUtil.get(i) > 65 && instances*2 <= LIMIT){
				instances *= 2;
				i += 10;
			}
			i++;
		}
		return instances;
	}
	
	public static void main(String[] args) {
		Integer averageUtil[] = new Integer[] {24, 25, 5, 6, 7, 10, 80, 5, 12, 16, 34, 27, 17, 50};
		List<Integer> a = Arrays.asList(averageUtil);
		int instances = 2;
		System.out.println(solution(instances, a));
	}
}
