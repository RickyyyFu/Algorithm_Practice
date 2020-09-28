package CutRibbon;

public class cut_Ribbon {
	public int cut(int[] arr, int k) {
	    int max_len = 0;
	    for (int num : arr)
	      max_len = Math.max(max_len, num);

	    int start = 0, end = max_len;

	    while (start + 1 < end) {
	      int mid = start + (end - start) / 2;

	      if (numbersCanCut(arr, mid) >= k) start = mid;
	      else end = mid;
	    }
	   
	    // 从 start和end中选一个return
	    return start;
	  }

	  private int numbersCanCut(int[] arr, int mid) {
	    int count = 0;
	    for (int num : arr)
	      count += num / mid;

	    return count;
	  }

}
