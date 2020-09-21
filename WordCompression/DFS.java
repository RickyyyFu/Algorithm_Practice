package WordCompression;

public class DFS {
	public static void main(String[] args) {
        String test = "abbcccb";
        String res = dfs(test);
        System.out.println(res);
    }

    private static String dfs(String test) {
        if(test.length() < 3) return test;
        
        char[] arr = test.toCharArray();
        int count = 1;
        int i = 0;
        for(i = 1; i < test.length(); i++){
            if(arr[i]==arr[i-1]){
                count++;
            }else{
                if(count>=3) break;
                else count = 1;
            }
        }
        if(count >= 3){
            String tmp = "";
            if(i-count>0){
                tmp+= test.substring(0,i-count);
            }
            tmp+=test.substring(i);
            return dfs(tmp);
        }
        return test;
    }
}
