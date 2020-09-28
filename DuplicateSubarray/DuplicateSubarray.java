package DuplicateSubarray;

import java.util.*;

//给一个array，问所有element都duplicate（出现次数＞1，比如［1，1，2，2］）的subarray有多少
public class DuplicateSubarray {
  public int solution(int[] array){
      Map<Integer, Integer> map = new HashMap<>();
      for(int i=0; i<array.length; i++){
          if(!map.containsKey(array[i])){
              map.put(array[i], 0);
          }
      }

      int right = 0;
      int left = 0;
      int res = 0;
      int n = array.length;
      while(right<n){
    	  // need array[right] == array[right] -> while loop to add ????
          map.put(array[right], map.get(array[right])+1);
          right++;
          while(duplicateCheck(map)){
              res++;
              System.out.println(map + " " + res);
              map.put(array[left], map.get(array[left])-1);
              left++;
          }
      }

      return res;

  }

  private boolean duplicateCheck(Map<Integer, Integer> map){
      for(int value: map.values()){
          if(value<2){
              return false;
          }
      }
      return true;
  }

  public static void main(String[] args){
	  DuplicateSubarray ds = new DuplicateSubarray();
      int[] array = new int[]{1,1,2,2};
      System.out.print(ds.solution(array));
  }
}
