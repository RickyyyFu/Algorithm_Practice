package RandomNumberGenerator;

import java.util.*;

/*
[1,2,3,4,5,6,7,8]
  l + (r-l) * random
  swap
  
  l:0, r:7 rand:5 [5,8,  3,4,1,6,7,2] ->l:1
  
  1/8
  7/8 * 1/7 = 1/8
  7/8 * 6/7 * 1/6 = 1/8
  .....
*/
class RandomGenerator {
  int[] arr;
  int mark;
  int min;
  int max;
  int range;
  
  Set<Integer> set = new HashSet<>();
  
  // if min < max
  // O(max-min)
  public void set_range(int min, int max){
    this.min = min;
    this.max = max;
    this.range = max-min+1;
    
    this.arr = new int[range];
    int i = 0;
    for(int k = min; k <= max; k++){
      arr[i++] = k;
    }
    mark = 0;
    
    
    if(!set.isEmpty()){
      for(int n : set){
        if(n >= min && n <= max){
          int idx = n - min;
          swap(arr, mark, idx);
          mark++;
          range--;
        }
      }
    }
  }
  
  // O(1) amortized 
  public int get_number(){
    
    if(mark == max-min+1) {
       mark = 0;
       range = max-min+1;
      set = new HashSet<>();
      //set_range(min, max);
      
    }
    
    int idx = mark + (int)(Math.random() * range);
    
    int res = arr[idx];
    set.add(res);
    swap(arr, mark, idx);
    mark++;
    range--;
    /*
    if(mark == max-min+1) {
      // mark = 0;
      // range = max-min+1;
      set = new HashSet<>();
      set_range(min, max);
    }
    */
    //amortized time complexity
    
    return res;
  } 
  
  public void swap(int[] arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
  
  public static void main(String[] args){
    RandomGenerator r = new RandomGenerator();
    r.set_range(2, 5);
    System.out.println(r.get_number()); // 3
    System.out.println(r.get_number()); // 4
    //System.out.println(r.get_number()); // 5
    
    r.set_range(8, 9);
    System.out.println(r.get_number()); // 3
    //System.out.println(r.get_number()); // 4
    
    r.set_range(1, 9);
    System.out.println(Arrays.toString(r.arr));
    System.out.println(r.get_number());
    System.out.println(r.get_number());
    
    System.out.println(r.get_number());
    System.out.println(r.get_number());
    System.out.println(r.get_number());
    System.out.println(r.get_number());
    System.out.println(r.get_number());
    
    System.out.println(r.get_number());
  }
  
  
}
