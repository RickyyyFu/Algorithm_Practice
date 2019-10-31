package longest_string_with_ABC;

import java.util.*;

public class ABC {
	static class letter{
		char ch;
		int freq;
		
		letter(char ch, int freq){
			this.ch = ch;
			this.freq = freq;
		}
	}
	
	public static String solution(int A, int B, int C) {
		PriorityQueue<letter> pq = new PriorityQueue<>((a, b) -> (b.freq - a.freq));
		if(A > 0) pq.offer(new letter('a', A));
		if(B > 0) pq.offer(new letter('b', B));
		if(C > 0) pq.offer(new letter('c', C));
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			letter first = pq.poll();
			char ch1 = first.ch;
			// if 'first' is only one kind of letter left
			if(pq.isEmpty()) {
				if(first.freq > 1) {
					sb.append(ch1);
				}
				sb.append(ch1);
				return sb.toString();
			}
			
			letter second = pq.poll();
			char ch2 = second.ch;
			
			// case 1: A > B -> 'aab'
			if(first.freq > second.freq) {
				sb.append(ch1).append(ch1);
				sb.append(ch2);
				first.freq -= 2;
				second.freq -= 1;
			}
			// case 2: A = B -> 'ab'
			else if(first.freq == second.freq) {
				sb.append(ch1);
				sb.append(ch2);
				first.freq -= 1;
				second.freq -= 1;
			}
			
			// add the rest of the letters to queue
			if(first.freq > 0) {
				pq.offer(first);
			}
			if(second.freq > 0) {
				pq.offer(second);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution(6, 1, 1));
		System.out.println(solution(1, 3, 1));
		System.out.println(solution(0, 1, 8));
		System.out.println(solution(5, 3, 3));
		System.out.println(solution(0, 0, 0));
	}
}
