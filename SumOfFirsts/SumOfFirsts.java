package SumOfFirsts;

import java.util.*;

/**
 * Sum of Firsts����һ������numbers���ظ�ѭ�����¼������裺
   Step1�����������ҵ���һ����Ϊ0����������indexΪi�������ȫΪ0���ؽ��res
   Step2����i��ʼ��ÿ�������������ȥnumbers������i�������ǣ�1. index==numbers.length; 2. �����С��numbers�����������������ֱ��ȥStep3
   Step3: ��numbers���뵽res����
   Step4: �ص�Step1
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
