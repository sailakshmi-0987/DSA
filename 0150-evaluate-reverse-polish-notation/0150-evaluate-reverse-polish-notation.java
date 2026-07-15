class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
                if(s.equals("+")){
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1+op2);
                }
                else if(s.equals("-")){
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2-op1);
                }else if(s.equals("*")){
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1*op2);
                }
                else if(s.equals("/")){
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2/op1);
                }else{
                    int s1 = Integer.parseInt(s);
                    stack.push(s1);
                }
            
        }
        return stack.pop();
    }
}