package WDLString;

public class WDLString {
	public static String wdlString(String s) {
		int w_cnt = 0;
		int d_cnt = 0;
		int l_cnt = 0;
		
		for(char c : s.toCharArray()) {
			if(c == 'w') w_cnt++;
			if(c == 'd') d_cnt++;
			if(c == 'l') l_cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		while(w_cnt > 0 || d_cnt > 0 || l_cnt > 0) {
			if(w_cnt > 0) {
				sb.append('w');
				w_cnt--;
			}
			if(d_cnt > 0) {
				sb.append('d');
				d_cnt--;
			}
			if(l_cnt > 0) {
				sb.append('l');
				l_cnt--;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(wdlString("wwwdddlll"));
		System.out.println(wdlString("wdddlll"));
		System.out.println(wdlString("lldddwww"));
	}
}
