package Amazon;

import java.util.*;

/**
 * 
 * 	@author Ricky
 *	calculate the biggest percentage jump if we add one more five-start to it
 *	O(N+C) C: the times from minimum rating to threshold 
 *	O(N)
 */
public class FiveStarSellers {
	public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold){
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> Double.compare(getIncreasing(l2), getIncreasing(l1)));
		for(List<Integer> rating : productRatings) {
			pq.offer(rating);
		}
		
		double rating_sum = 0.0;
		for(List<Integer> rating : productRatings) {
			rating_sum += (double)rating.get(0)/rating.get(1);
		}
		
		int res = 0;
		while(rating_sum < (double)ratingsThreshold*productRatings.size()/100) {
			List<Integer> original_rating = pq.poll();
			rating_sum += getIncreasing(original_rating);
			List<Integer> new_rating = new ArrayList<>();
			new_rating.add(original_rating.get(0)+1);
			new_rating.add(original_rating.get(1)+1);
			pq.offer(new_rating);
			
			res++;
		}
		return res;
	
	}
	
	public static double getIncreasing(List<Integer> list) {
		return (double)(list.get(0)+1)/(list.get(1)+1) - (double)list.get(0)/list.get(1);
	}
	
	public static void main(String[] args) {
		List<List<Integer>> ratings = new ArrayList<List<Integer>>(){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
                add(Arrays.asList(4,4));
                add(Arrays.asList(1,2));
                add(Arrays.asList(3,6));
            }
        };
        int threshold = 77;
        System.out.println(fiveStarReviews(ratings, threshold));
    }
}
