import java.util.ArrayDeque;
class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < number.length(); i++) {
            while (k>0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        while(k > 0) {
            
                    stack.pop();
                    k--;
        }
        while(!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }

        return answer.toString();
    }
}