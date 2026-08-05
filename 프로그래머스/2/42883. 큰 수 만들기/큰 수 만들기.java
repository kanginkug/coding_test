import java.util.Stack;
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            // 새로 들어올 숫자 c가 스택 상단 숫자보다 크면 계속 pop
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        // 만약 "9876", k=2 처럼 이미 내림차순이라 k가 남았다면 뒤에서부터 k개 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Stack의 모든 문자를 하나로 합치기
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }
}