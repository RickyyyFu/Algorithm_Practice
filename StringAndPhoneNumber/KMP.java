package StringAndPhoneNumber;

import java.util.*;

public class KMP {
	static Map<Character, Character> map = new HashMap<>();
	static {
		map.put('A', '2');
		map.put('B', '2');
		map.put('C', '2');
		map.put('D', '3');
		map.put('E', '3');
		map.put('F', '3');
		map.put('G', '4');
		map.put('H', '4');
		map.put('I', '4');
		map.put('J', '5');
		map.put('K', '5');
		map.put('L', '5');
		map.put('M', '6');
		map.put('N', '6');
		map.put('O', '6');
		map.put('P', '7');
		map.put('Q', '7');
		map.put('R', '7');
		map.put('S', '7');
		map.put('T', '8');
		map.put('U', '8');
		map.put('V', '8');
		map.put('W', '9');
		map.put('X', '9');
		map.put('Y', '9');
		map.put('Z', '9');
	}
	
	public static List<String> vanity(List<String> codes, List<String> numbers){
		Set<String> set = new HashSet<>();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		for(String code : codes) {
			Set<String> visited = new HashSet<>();
			String code_num = decode(code);
			for(String number : numbers) {
				if(set.contains(number)) continue;
				if(visited.contains(number)) continue;
				visited.add(number);
				
				if(kmp(number, code_num) != -1) set.add(number);
			}
		}
		
		List<String> list = new ArrayList<>();
		for(String number : set) list.add(number);
		Collections.sort(list);
		
		return list;
	}
	
	public static String decode(String code) {
		StringBuilder sb = new StringBuilder();
		for(char c : code.toCharArray()) {
			sb.append(map.get(c));
		}
		return sb.toString();
	}
	
	public static int kmp(String source, String pattern) {
		int i = 0;
		int j = 0;
		char[] src = source.toCharArray();
		char[] ptn = pattern.toCharArray();
		int sLen = src.length;
		int pLen = ptn.length;
		
		int[] next = getNext(ptn);
		while(i < sLen && j < pLen){
			// if j==-1 or src[i]==ptn[j], i++ j++
			if(j == -1 || src[i] == ptn[j]) {
				i++;
				j++;
			}
			// if j!=-1 && src[i]!=ptn[j], j=next[j](let pattern move rightward j-next[j])
			else {
				j = next[j];
			}
		}
		
		if(j == pLen) {
			return i - j;
		}
		return -1;
	}
	
	public static int[] getNext(char[] p) {
		/**
		 * // 已知next[j] = k,利用递归的思想求出next[j+1]的值
            // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
            // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
            // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
            // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
		 * if next[j] = k, get next[j+1] by recursion
		 * 1. if p[j] = p[k], next[j+1] = next[k] + 1 
		 * 2. if p[j] != p[k], k = next[k]
		 * 		if p[j] == p[k], next[j+1] = k+1
		 * 		if not, k = next[k], until k = -1(k = next[0]) or p[j]=p[[k]
		 */
		int pLen = p.length;
		int[] next = new int[p.length];
		int k = -1;
		int j = 0;
		next[0] = -1;
		
		while(j < pLen-1){
			if(k == -1 || p[j] == p[k]) {
				j++;
				k++;
				if(p[j] != p[k]) {
					next[j] = k;
				}
				else {
					next[j] = next[k]; // 不能出现p[j] = p[next[j]],所以如果出现这种情况则继续递归,如 k = next[k], k = next[[next[k]]
				}
			}
			else {
				k = next[k];
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
		List<String> codes = new ArrayList<>();
		codes.add("TWLO");
		codes.add("CODE");
		codes.add("HTCH");
		
		List<String> numbers = new ArrayList<>();
		numbers.add("+17474824380");
		numbers.add("+14157088956"); 
		numbers.add("+919810155555"); 
		numbers.add("+15109926333"); 
		numbers.add("+1415123456"); 
		
		System.out.println(vanity(codes, numbers));
	}
}
