package DiagonalOutputSortByFrequencyMatrix;

//�������ڵ��������ְ�Ƶ������Ȼ������½ǽ��������Ƶ����ȾͰ���С�š�
//����:
//[[2,2,3],
//[1,1,1],
//[2,2,4]]
//
//��Ƶ��������:
//[3, 4,1,1,1,2,2,2,2]
//
//�����ʱ�������б���� (����m[2][2], Ȼ��m[2][1],Ȼ��m[1][2], Ȼ��m[2][0], Ȼ��[1][1] .... ���m[0][0])
//[[2,2,2],
//[2,1,1],
//[1,4,3]]

import java.util.*;

public class sortmatrixByoccurance {
 public void solution(int[][] matrix){
     Map<Integer, Integer> map = new HashMap<>();
     int m = matrix.length;
     int n = matrix[0].length;
     for(int i=0; i<m; i++){
         for(int j=0; j<n; j++){
             map.put(matrix[i][j], map.getOrDefault(matrix[i][j],0)+1);
         }
     }

     List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
     Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
         @Override
         public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
             if(o1.getValue() == o2.getValue()){
                 return o1.getKey().compareTo(o2.getKey());
             }else{
                 return o1.getValue().compareTo(o2.getValue());
             }
         }
     });
     int index = 0;
     for(int line=m+n-1; line>=1; line--){
         int start_col = Math.max(0, line-m);
         int count = Math.min(m, Math.min(line, n-start_col));
    	 for(int k = 0; k < count; k++){
             matrix[Math.min(line, m)-k-1][start_col+k] = list.get(index).getKey();
           
             list.get(index).setValue(list.get(index).getValue()-1);
             if(list.get(index).getValue() == 0){
                 index++;
             }
         }
     }

 }

 public static void main(String[] args){
     sortmatrixByoccurance sb = new sortmatrixByoccurance();
     int[][] matrix = new int[][]{{2,2,3,3},{1,1,1,2},{2,2,4,4},{9,10,11,12}};
     sb.solution(matrix);
     for(int i=0; i<matrix.length; i++){
         for(int j=0; j<matrix[0].length; j++){
             System.out.print(matrix[i][j]);
             System.out.print(" ");
         }
         System.out.print("\n");
     }
 }
}

