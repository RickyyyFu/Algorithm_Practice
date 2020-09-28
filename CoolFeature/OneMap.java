package CoolFeature;

import java.util.*;

/**
 * Give three array a, b and query. This one is hard to explain. Just read the example. Input:
		a = [1, 2, 3]
		b = [3, 4]
		query = [[1, 5], [1, 1 , 1], [1, 5]] Output:
		[2, 1]
		Explain:
		Just ignore every first element in sub array in query.
		So we will get a new query like this query = [[5], [1, 1], [5]]
		Only record the result when meet the single number in new query array.
		And the rule of record is find the sum of the single number.
		The example above is 5 = 1 + 4 and 5 = 2 + 3, there are two result.
		So currently the output is [2]
		When we meet the array length is larger than 1, such as [1, 1]. That means we will replace the b[x] = y, x is the first element, y is second element. So in this example, the b will be modify like this b = [1, 4]
		And finally, we meet the [5] again. So we will find sum again. This time the result is 5 = 1 + 4. So currently the output is [2, 1]
		note: Don't have to modify the query array, just ignore the first element.
 *
 */

public class OneMap {
    public static int[] coolFeature(int[] a, int[] b, int[][] querys) {

        List<Integer> ans = new ArrayList<Integer>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for(int[] query : querys) {
            if(query.length == 2) {
                int temp = findSum(map, b, query[1]);
                ans.add(temp);
            } else if (query.length == 3) {
                changeArray(b, query[1], query[2]);
            }
        }
        System.out.println(ans);
        int[] ansArray = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    public static int findSum(Map<Integer, Integer> map, int[] b, int target) {
        int res = 0;
        for (int i = 0; i < b.length; i++) {
            if(map.containsKey(target - b[i])) {
                res += map.get(target - b[i]);
            }
        }
        return res;
    }

    public static void changeArray(int[] b, int loc, int num) {
        b[loc] = num;
    }
    
    public static void main(String[] args){
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{3,4};
        int[][] query = new int[][]{{1,5}, {1,1,1}, {1,5}};
        System.out.print(coolFeature(a, b, query));
    }

}
