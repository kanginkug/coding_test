import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] charS = s.toCharArray();
        Stack<String> stack = new Stack<>();
        if(charS[0] == ')') {
            answer = false;
        } else {
            for (char aChar : charS) {
                if(!stack.isEmpty()) {
                    if(stack.peek().equals("(") && aChar == ')'){
                        stack.pop();
                    } else {
                        stack.push(String.valueOf(aChar));
                    }
                } else {
                    stack.push(String.valueOf(aChar));
                }
            }
        }

        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}