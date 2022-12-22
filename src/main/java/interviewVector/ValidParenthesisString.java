package interviewVector;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        ValidParenthesisString obj = new ValidParenthesisString();
//        obj.checkValidString("()");
        obj.checkValidString("(*)");
        obj.checkValidString("(*))");
    }
    public boolean checkValidString(String s) {
        return helper(new Stack<Character>(), s.toCharArray(), 0);
    }
    boolean helper(Stack<Character> stack, char[] arr, int i) {
        if(i == arr.length) {
            if(stack.isEmpty()) return true;
            else return false;
        }
        if(arr[i] == '*') {
            arr[i] = '(';
            boolean r1 = helper(stack, arr, i);
            arr[i] = ')';
            boolean r2 = helper(stack, arr, i);
            boolean r3 = helper(stack, arr, i+1);
            return r3 || r1 || r2;
        } else {
            if(arr[i] == '(')
                stack.push('(');
            else if(!stack.isEmpty())
                stack.pop();
            else
                return false;
        }
        return helper(stack, arr, i+1);
    }
}
