package TwoSumWithDuplicates;

import java.util.*;
public class TwoSumWIthDuplicates {
	public List<List<Integer>> twoSum(int[] num, int target) {
	    List<List<Integer>> listSet = new ArrayList<List<Integer>>();
	    int n = num.length;
	    if (n < 2)  return listSet;
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < n; i++) {
	        int key1 = num[i], key2 = target - num[i];
	        if (map.containsKey(key2) && map.get(key2) > 0) {
	            List<Integer> list = new ArrayList<Integer>();
	            if (key1 < key2)    list = Arrays.asList(key1, key2);
	            else                list = Arrays.asList(key2, key1);
	            if (!listSet.contains(list)) listSet.add(list);
	            map.put(key2, map.get(key2) - 1);
	        } else {
	            if (!map.containsKey(key1)) map.put(key1, 1);
	            else                        map.put(key1, map.get(key1) + 1);
	        }
	    }
	    return listSet;
	}
}
