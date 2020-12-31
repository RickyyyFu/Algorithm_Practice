package Calculator;

import java.util.Stack;

// + - * /

// stack + preNum
class LC772_WithEverything {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Stack<Integer> n_stack = new Stack<>();
        Stack<Character> o_stack = new Stack<>();
        int curNum = 0;
        int preNum = 0;
        int sum = 0;
        char operate = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum*10 + (c-'0');
            }
            // meet (), similar to create new curNum
            if(c == '('){
                n_stack.push(sum); // block sum, previous sum is stored in stack
                n_stack.push(preNum);
                o_stack.push(operate);

                sum = 0; 
                curNum = 0;
                preNum = 0;
                operate = '+';
            }
            if(c == ')'){
                if(operate == '+' || operate == '-') {
                    sum += preNum;
                    preNum = (operate == '+') ? curNum : -curNum;
                }
                else if(operate == '*'){
                    preNum = preNum * curNum;
                }
                else if(operate == '/'){
                    preNum = preNum / curNum;
                }
                // end this block
                sum += preNum;
                
                curNum = sum;
                operate = o_stack.pop();
                preNum = n_stack.pop();
                sum = n_stack.pop();
            }
            // !!!!!!!!! note: not else if
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length()-1){
                // only last operate is +/-, add preNum to res
                // 14 + pre (+/-) cur (c)....
                if(operate == '+' || operate == '-'){
                    sum += preNum;
                    preNum = (operate == '+') ? curNum : -curNum;
                }
                // 14 + pre (*||/) cur (c)....
                else if(operate == '*'){
                    preNum = preNum * curNum;
                }
                else if(operate == '/'){
                    preNum = preNum / curNum;
                }
                curNum = 0;
                operate = c;
            }
        }
        sum += preNum;
        return sum;
    }
}