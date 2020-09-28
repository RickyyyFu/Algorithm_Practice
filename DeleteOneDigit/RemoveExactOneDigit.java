package DeleteOneDigit;

public class RemoveExactOneDigit {
	public int solution(String a, String b){
        if(a==null || a.length() == 0 || b==null || b.length() == 0) return 0;
        int res = 0;
        for(int i=0; i<b.length(); i++){
            String newstring = b.substring(0, i)+b.substring(i+1);
            if(newstring.compareTo(a)>0) res++;
        }
        for(int i=0; i<a.length(); i++){
            String newstring = a.substring(0, i)+a.substring(i+1);
            if(newstring.compareTo(a)>0) res++;
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
