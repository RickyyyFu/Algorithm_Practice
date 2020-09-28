package SumOfFirsts;

import java.util.*;

/**
 * Sum of Firsts：给一个数组numbers，重复循环以下几个步骤：
   Step1：自左向右找到第一个不为0的数（假设index为i），如果全为0返回结果res
   Step2：从i开始，每个后面的数都减去numbers，包括i本身，除非：1. index==numbers.length; 2. 这个数小于numbers，遇到以上两种情况直接去Step3
   Step3: 将numbers加入到res里面
   Step4: 回到Step1
 */

public class SumOfFirsts {
	public static List<Integer> sumofFirsts(int[] numbers){
		List<Integer> res = new ArrayList<>();
		
		int i = 0;
		while(i < numbers.length) {
			if(numbers[i] == 0) {
				i++; // step 1
				continue;
			}
			
			int num = numbers[i];
			for(int j = i; j < numbers.length; j++) { // step 2
				if(numbers[j] < num) {
					break;
				}
				numbers[j] -= num;
			}
			res.add(num); // step 3
			i++; // step 4
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] m1 = {1,2,3,4,5,6};
		System.out.println(sumofFirsts(m1));
		int[] m2 = {0,0,0,0,0,0};
		System.out.println(sumofFirsts(m2));
		int[] m3 = {1,1,1,1,1,1};
		System.out.println(sumofFirsts(m3));
	}
}
