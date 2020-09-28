package LongestSubarrayWithLimitedElement;

import java.util.HashSet;
import java.util.Set;

//�ȱ���һ�飬��ȡ��b��ȳ��ȵ�substring��Ȼ���ж��Ƿ��b��ȣ������ȣ����ж�substring���ҵ�Ԫ���Ƿ���c��
public class longestsubarray {
    public boolean solution(String a, String b, String c) {
        Set<Character> set = new HashSet<>();

        for (char element : c.toCharArray()) {
            set.add(element);
        }
        for (char element : b.toCharArray()) {
            if (!set.contains(element)) {
                return false;
            }
        }
        if (b.length() > a.length()) return false;

        String res = "";
        int len = b.length();
        int[] pos = new int[2];
        for (int i = 0; i <= a.length() - len; i++) {
            String substring = a.substring(i, i + len);
            if (substring.equals(b)) {
                res = substring;
                pos[0] = i - 1;
                pos[1] = i + len;
            }
        }

        if(res == "") return false;

        if (pos[0] == -1 || pos[1] == a.length()) {
            if(pos[0] == -1 && pos[1] == a.length()){
                return true;
            }else if(pos[0] == -1){
                return !set.contains(a.charAt(pos[1]));
            }else if(pos[1] == a.length()){
                return !set.contains(a.charAt(pos[0]));
            }
        }

        return !set.contains(a.charAt(pos[0])) && !set.contains(a.charAt(pos[1]));
    }

    public static void main(String[] args){
        String a = "cccbbaab";
        String b = "cccbbaab";
        String c = "abc";
        longestsubarray ls = new longestsubarray();
        System.out.print(ls.solution(a,b,c));
    }
}

