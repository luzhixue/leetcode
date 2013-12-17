public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> operands = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            try{
                int number = Integer.parseInt(tokens[i]);
                operands.push(number);
            }
            catch(NumberFormatException e){
                int op2 = operands.pop();
                int op1 = operands.pop();//the second pop is the first operand (matters for division!)
                int eval;
                if(tokens[i].equals("+"))
                    eval = op1 + op2;
                else if(tokens[i].equals("-"))
                    eval = op1 - op2;
                else if(tokens[i].equals("*"))
                    eval = op1 * op2;
                else if(tokens[i].equals("/"))
                    eval = op1 / op2;
                else
                    return 0;
                operands.push(eval);
            }
        }
        return operands.pop();
    }
}
