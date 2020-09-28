package DeleteOneDigit;

//�o�ɂ��ִ� a, b
//����ִ�b�h��һ���������� a�ִ�С�b�Ŀ����Ў׷N (alphanumeric sort)
//����: a="d1c" b = "1b2z"
//�t������b = "b2z"
//�� b = "1bz"
//�ɷN��r�����^
public class RemoveOneNumber {
	public int solution(String a, String b){
        if(a==null || a.length() == 0 || b==null || b.length() == 0) return 0;
        int res = 0;
        for(int i=0; i<b.length(); i++){
            
        	if(b.charAt(i)>='0' && b.charAt(i)<='9'){
                String newstring = b.substring(0, i)+b.substring(i+1);
                if(newstring.compareTo(a)>0){
                    res++;
                }
                
            }
        }
        return res;
    }

    public static void main(String[] args){
        String a = "ab12c";
        String b = "1zz456";
        RemoveOneNumber rd = new RemoveOneNumber();
        System.out.print(rd.solution(a, b));
    }
}
