package Amazon;

import java.util.*;

/**
 * 
 * @author Ricky
 *	HashMap + Queue
 *	O(N+T)
 *	O(N)
 */
public class Turnstile {
	public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
		Map<Integer, List<int[]>> map = new HashMap<>(); // key: time    value: list of customers (int[]{index, direction})
		for(int i = 0; i < numCustomers; i++) {
			if(!map.containsKey(arrTime[i])) map.put(arrTime[i], new ArrayList<int[]>());
			map.get(arrTime[i]).add(new int[]{i, direction[i]});
		}
		
		int[] res = new int[numCustomers];
		Queue<Integer> entry = new LinkedList<>();
		Queue<Integer> exit = new LinkedList<>();
		int time = 0;
		int status = -1;  // -1: not used at previous second,	0: used as entry at previous second,	1: used as exit at previous second
		while(numCustomers > 0) {
			// add customers who reached at this time to queue
			if(map.containsKey(time)) {
				List<int[]> cus_info = map.get(time);
				for(int[] info : cus_info) {
					if(info[1] == 0) entry.offer(info[0]);
					else exit.offer(info[0]);
				}
			}
			
			// there is no waiting customers
			if(entry.isEmpty() && exit.isEmpty()) {
				status = -1;
				time++;
				continue;
			}
			
			// 3 cases situation of used status at previous second
			if(status == 0) {
				// in the previous second the turnstile was used as an entrance, then the customer who wants to enter goes first.
				if(!entry.isEmpty()) {
					int cus_idx = entry.poll();
					res[cus_idx] = time;
					status = 0;
				}
				else {
					int cus_idx = exit.poll();
					res[cus_idx] = time;
					status = 1;
				}
			}
			else {
				// in the previous second the turnstile was used as an exit or not used, then the customer who wants to enter goes first.
				if(!exit.isEmpty()) {
					int cus_idx = exit.poll();
					res[cus_idx] = time;
					status = 1;
				}
				else {
					int cus_idx = entry.poll();
					res[cus_idx] = time;
					status = 0;
				}
			}
			time++;
			numCustomers--;
		}
		for(int n : res) {
			System.out.print(n + " ");
		}
		System.out.println();
		return res;
	}
	
	public static void main(String[] args) {
		int[] a1 = {0, 0, 1,5}; 
		int[] d1 = {0, 1, 1, 0};
		getTimes(4, a1, d1);
		
		int[] a2 = {0,1,1,3,3}; 
		int[] d2 = {0,1,0,0,1};
		getTimes(5, a2, d2);
	}
}
