import java.util.ArrayDeque;
class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < number.length(); i++) {
            while(!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                k--;
                stack.pop();
            }
            stack.push(number.charAt(i));
        }
        if(k > 0) {
            for(int i = 0; i < k; i++) {
                stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }

        return answer;
    }
}