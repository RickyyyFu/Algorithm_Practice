package DecodeString;

import java.util.*;

// recursive
// stack
/**
 * 	stack - similar to calculator with parentheses
 * 
    str stack
    num stack
*/
public class LC394 {

    public String decodeString(String s) {
        Stack<StringBuilder> s_stack = new Stack<>();
        Stack<Integer> n_stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        String num = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num += c;
            }
            else if(c == '['){
                s_stack.push(sb);
                n_stack.push(Integer.valueOf(num));
                sb = new StringBuilder();
                num = "";
            }
            else if(c == ']'){
                StringBuilder cur = new StringBuilder();
                for(int i = n_stack.pop(); i > 0; i--){ // note: only pop once
                    cur.append(sb);
                }
                sb = s_stack.pop().append(cur);
            }
            else{ // c == letter
                sb.append(c);
            }
        }
        return sb.toString();
    }
	
}
