package SubstringNum_Divide;

//��һ������456�����������ж��ٸ����Ա�3���������硰4������5��������6������45���� ��56������456��

import java.util.HashSet;
import java.util.Set;

public class SubstringNum_Divide {
  public int solution(String num){
      if(num == null || num.length() == 0) return 0;
      int res = 0;
      Set<Integer> set = new HashSet<>();
      for(int i=0; i<num.length(); i++){
          for(int j=i+1; j<=num.length(); j++){
              String val = num.substring(i, j);
              int temp = Integer.parseInt(val);
              if(!set.contains(temp) && temp%3==0){
                  res++;
              }
              set.add(temp);
          }
      }
      return res;
  }

  public static void main(String[] args){
      String num = "999";
      SubstringNum_Divide nd = new SubstringNum_Divide();
      System.out.print(nd.solution(num));
  }
}